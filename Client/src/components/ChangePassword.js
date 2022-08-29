import styled from 'styled-components';
import MyButton from './MyButton';
const SignupBox = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 20px;
  margin-bottom: 10px;
  padding-top: 20px;
  padding-left: 20px;
  border: 1px solid #d0d4d7;
  border-radius: 5px;
  min-width: 350px;
  max-width: 1040px;
  span {
    margin-top: 10px;
    font-size: 16px;
    font-weight: 700;
    margin-right: 180px;
    white-space: nowrap;
  }
  input {
    height: 40px;
    min-width: 350px;
    font-size: 14px;
    color: #363b3f;
    text-indent: 15px;
    border: 1px solid #d5d7d9;
    border-radius: 5px;
    width: 280px;
  }
  input:focus {
    border: 1px solid cornflowerblue;
    border-radius: 2px;
    outline: none;
    box-shadow: 0 0 0 3px #cde9fe;
  }
  button {
    font-size: 14px;
    min-width: 350px;
    height: 40px;
    margin: 20px 0;
  }
  p {
    margin-top: 20px;
    color: #7f868d;
    font-size: 14px;
  }
`;

const ChangePassWord = () => {
  return (
    <SignupBox>
      <span>Current password</span>
      <input type="text"></input>
      <span>New password</span>
      <input type="password"></input>
      <span>New password (again)</span>
      <input type="password"></input>
      <p>
        Passwords must contain at least eight characters, including at least 1
        letter and 1 number.
      </p>
      <MyButton text={'Change PassWord'} type={'blue'} onClick={() => {}} />
    </SignupBox>
  );
};
export default ChangePassWord;
