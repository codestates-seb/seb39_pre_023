import { Link } from 'react-router-dom';
import styled from 'styled-components';
import MyButton from '../../components/MyButton';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  // faGoogle,
  faStackOverflow,
} from '@fortawesome/fontawesome-free-brands';

const Login = () => {
  return (
    <Container>
      <SigninBox>
        <FontAwesomeIcon icon={faStackOverflow} className="stacklogo" />
        <BtnWrapper>
          {/* <FontAwesomeIcon icon={faGoogle} className="gglogo" /> */}
          <MyButton
            text={'Log in with Google'}
            type={'default'}
            onClick={() => {}}
          />
        </BtnWrapper>
        <LoginBox>
          <span>Id</span>
          <input type="text"></input>
          <span>Password</span>
          <input type="password"></input>
          <MyButton text={'Log in'} type={'blue'} onClick={() => {}} />
        </LoginBox>
        <SignupBox>
          <p>
            Don&apos;t have an account?
            <Link to="/signup">
              <span className="signupbtn">Sign up</span>
            </Link>
          </p>
        </SignupBox>
      </SigninBox>
    </Container>
  );
};

export default Login;

const Container = styled.div`
  background-color: #f1f2f3;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
`;
const SigninBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 300px;
  height: 570px;
  .stacklogo {
    margin-bottom: 20px;
    font-size: 35px;
  }
`;
const LoginBox = styled.div`
  display: flex;
  flex-direction: column;
  background-color: white;
  justify-content: center;
  align-items: center;
  padding: 30px;
  width: 320px;
  height: 280px;
  border-radius: 10px;
  box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
  > span {
    font-size: 16px;
    font-weight: 700;
    margin-right: 230px;
    margin-bottom: 5px;
  }
  span:nth-of-type(2) {
    margin-right: 170px;
  }
  input {
    height: 35px;
    font-size: 16px;
    color: #363b3f;
    text-indent: 15px;
    margin-bottom: 20px;
    border: 1px solid #d5d7d9;
    border-radius: 5px;
    width: 250px;
  }
  input:focus {
    border: 1px solid cornflowerblue;
    border-radius: 2px;
    outline: none;
    box-shadow: 0 0 0 3px #cde9fe;
  }
  button {
    margin-top: 10px;
    font-size: 14px;
    width: 250px;
    height: 35px;
  }
`;
const SignupBox = styled.div`
  margin-top: 50px;
  display: flex;
  width: 240px;
  justify-content: space-around;
  p {
    font-size: 14px;
  }
  span {
    font-size: 14px;
    color: #3b79c8;
    margin-left: 10px;
  }
  a {
    text-decoration: none;
  }
`;
const BtnWrapper = styled.div`
  margin-bottom: 30px;
  position: relative;
  button {
    color: #44484c;
    border: 1px solid #d7d9dc;
    width: 320px;
    font-size: 14px;
    height: 37px;
  }
  .gglogo {
    position: absolute;
    right: 210px;
    top: 10px;
    font-size: 20px;
  }
`;
