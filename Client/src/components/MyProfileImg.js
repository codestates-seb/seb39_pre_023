import { useRef, useState } from 'react';
import styled from 'styled-components';
import axios from 'axios';
import imageCompression from 'browser-image-compression';
import { getLoginCookie } from '../lib/cookie';
/* eslint-disable react/prop-types */
// axios.defaults.withCredentials = false;

const MyProfileImg = ({ userId }) => {
  // const [defaultImg, setDefault] = useState('');
  const [preview, setPreview] = useState(null);
  const imgInput = useRef(null);
  const onChangeImgBtnClick = (e) => {
    e.preventDefault();
    imgInput.current.click();
  };
  const onSaveImg = async (e) => {
    e.preventDefault();
    setPreview(URL.createObjectURL(e.target.files[0]));
    const imgFile = e.target.files[0];
    const options = {
      maxSizeMB: 2,
      maxWidthOrHeight: 170,
      useWebWorket: true,
    };
    try {
      const compressedFile = await imageCompression(imgFile, options);
      URL.revokeObjectURL(URL.revokeObjectURL(preview));
      const compressedImgURL =
        imageCompression.getDataUrlFromFile(compressedFile);
      compressedImgURL.then((result) => {
        setPreview(result);
      });
      const formData = new FormData();
      formData.append('file', compressedFile);
      formData.append('memberId', userId);
      const config = {
        headers: {
          Authorization: getLoginCookie(),
          'content-type': 'multipart/form-data',
        },
      };
      axios
        .post('http://3.39.180.45:56178/DBtest/upload', formData, config)
        .then((res) => {
          console.log(res.data);
          console.log('서버에 이미지 등록성공');
        })
        .catch((err) => {
          console.log(err);
          console.log('이미지 등록 실패ㅜ');
        });
    } catch (err) {
      console.log(err);
    }
  };
  // const onDeletePreview = () => {
  //   setPreview(URL.revokeObjectURL(preview));
  // };
  return (
    <ImgContainer>
      <ImgWrapper>
        <h4>Profile image</h4>
        <img
          src={
            !preview
              ? `http://3.39.180.45:56178/DBtest/download?memberId=${userId}`
              : preview
          }
          alt="profileImage"
        ></img>
        <input
          type="file"
          ref={imgInput}
          accept="image/*"
          onChange={(e) => onSaveImg(e)}
          style={{ display: 'none' }}
        ></input>
        <button onClick={(e) => onChangeImgBtnClick(e)} className="changeImg">
          Change picture
        </button>
      </ImgWrapper>
      {/* <div className="deleteBtnWrapper">
        <button
          className="deleteBtn"
          onClick={() => {
            onDeletePreview();
          }}
        >
          Delete image
        </button>
      </div> */}
    </ImgContainer>
  );
};
export default MyProfileImg;
const ImgContainer = styled.div`
  display: flex;
  /* .deleteBtnWrapper {
    margin-top: 186px;
    display: flex;
    flex-direction: column;
  }
  .deleteBtn {
    cursor: pointer;
    width: 100px;
    height: 35px;
    padding: 5px 5px;
    background-color: #0a95ff;
    color: white;
    border: 1px solid #0a95ff;
    border-radius: 5px;
  }
  .deleteBtn:hover {
    background-color: #066ac8;
  } */
`;
const ImgWrapper = styled.div`
  display: flex;
  flex-direction: column;
  width: 185px;
  div {
    font-weight: 400;
    font-size: 16px;
  }
  img {
    width: 165px;
    height: 165px;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
  }
  .changeImg {
    background-color: #535960;
    border: 1px solid #535960;
    color: white;
    width: 165px;
    height: 32px;
    padding: 5px;
    cursor: pointer;
    border-bottom-right-radius: 5px;
    border-bottom-left-radius: 5px;
  }
  .changeImg:hover {
    background-color: #2e3438;
    border-color: #2e3438;
  }
`;
