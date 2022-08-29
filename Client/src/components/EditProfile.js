import { useRef, useState } from 'react';
import styled from 'styled-components';
import MyButton from './MyButton';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCheck } from '@fortawesome/free-solid-svg-icons';
/* eslint-disable react/prop-types */

const EditProfile = ({ setIsProfile }) => {
  const [preview, setPreview] = useState(null);
  const [isSaved, setIsSaved] = useState(false);
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
    <Container>
      <ImgContainer>
        <ImgWrapper>
          <h4>Profile image</h4>
          <img
            src={
              preview === undefined
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
      <InputContainer>
        <h4>Display name</h4>
        <input type="text"></input>
        <h4>Location</h4>
        <input type="text"></input>
        <h4>About me</h4>
        <input type="textarea"></input>
        <div>About내용상태그잡채뿌리기</div>
      </InputContainer>
      <BtnContainer>
        {isSaved ? (
          <div className="msgContainer">
            <FontAwesomeIcon icon={faCheck} className="check" />
            <h4>Your profile has been saved successfully.</h4>
          </div>
        ) : null}
        <div className="btnwrapper">
          <MyButton
            text={'Save profile'}
            onClick={() => {
              setIsSaved(!isSaved);
            }}
            type={'blue'}
          />
          <MyButton
            text={'Cancel'}
            onClick={() => {
              setIsProfile(true);
            }}
          />
        </div>
      </BtnContainer>
    </Container>
  );
};
export default EditProfile;

const Container = styled.h3`
  display: flex;
  flex-direction: column;
  margin-top: 20px;
  margin-bottom: 10px;
  padding-top: 20px;
  padding-left: 20px;
  border: 1px solid #d0d4d7;
  border-radius: 5px;
  max-width: 1040px;
`;
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
const InputContainer = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 20px;
  input {
    margin-top: 5px;
    margin-bottom: 10px;
    height: 35px;
    width: 420px;
    font-size: 14px;
    color: #363b3f;
    text-indent: 10px;
    border: 1px solid #d5d7d9;
    border-radius: 3px;
  }
  input:nth-of-type(3) {
    width: 780px;
    margin-bottom: 10px;
  }
  input:focus {
    border: 1px solid cornflowerblue;
    border-radius: 2px;
    outline: none;
    box-shadow: 0 0 0 3px #cde9fe;
  }
  div {
    font-weight: 400;
    font-size: 14px;
  }
`;
const BtnContainer = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 40px;
  margin-bottom: 20px;
  .msgContainer {
    display: flex;
    flex-direction: column;
    height: 140px;
    width: 840px;
    border: 1px solid green;
    background-color: #edf8f0;
    align-items: center;
    justify-content: center;
  }
  .btnwrapper {
    display: flex;
    width: 210px;
    justify-content: space-between;
    margin-top: 30px;
  }
  button {
    width: 100px;
    height: 40px;
    padding: 10px 10px;
  }
  button:nth-of-type(2) {
    color: #0289fe;
    border: none;
  }
`;
