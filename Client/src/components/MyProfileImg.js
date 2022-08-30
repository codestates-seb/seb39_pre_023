import { useRef, useState } from 'react';
import styled from 'styled-components';
import axios from 'axios';
axios.defaults.withCredentials = false;

const MyProfileImg = () => {
  const [preview, setPreview] = useState(null);
  const imgInput = useRef(null);
  const onChangeImgBtnClick = (e) => {
    e.preventDefault();
    imgInput.current.click();
  };
  const onChangePreview = (e) => {
    e.preventDefault();
    setPreview(URL.createObjectURL(e.target.files[0]));
    console.log(e.target.files[0]);
  };
  const onDeletePreview = () => {
    setPreview(URL.revokeObjectURL(preview));
  };
  return (
    <ImgContainer>
      <ImgWrapper>
        <h4>Profile image</h4>
        <img
          src={
            !preview
              ? 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2iFvPbCvVHMQrdGkTuAPa1I2JS2-tHFhTKg&usqp=CAU'
              : preview
          }
          alt="profileImage"
        ></img>
        <input
          type="file"
          ref={imgInput}
          accept="image/*"
          onChange={(e) => onChangePreview(e)}
          style={{ display: 'none' }}
        ></input>
        <button onClick={(e) => onChangeImgBtnClick(e)} className="changeImg">
          Change picture
        </button>
      </ImgWrapper>
      <div className="deleteBtnWrapper">
        <button
          className="deleteBtn"
          onClick={() => {
            onDeletePreview();
          }}
        >
          Delete image
        </button>
      </div>
    </ImgContainer>
  );
};
export default MyProfileImg;
const ImgContainer = styled.div`
  display: flex;
  .deleteBtnWrapper {
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
  }
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
