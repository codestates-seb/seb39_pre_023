import { Link } from 'react-router-dom';
import styled from 'styled-components';
import MyButton from '../../components/MyButton';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faGoogle,
  faStackOverflow,
} from '@fortawesome/fontawesome-free-brands';

const Login = () => {
  return (
    <Container>
      <SigninBox>
        <FontAwesomeIcon icon={faStackOverflow} className="stacklogo" />
        <BtnWrapper>
          <FontAwesomeIcon icon={faGoogle} className="gglogo" />
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
  width: 450px;
  height: 550px;
  .stacklogo {
    margin-bottom: 20px;
    font-size: 60px;
  }
`;
const LoginBox = styled.div`
  display: flex;
  flex-direction: column;
  background-color: white;
  justify-content: center;
  align-items: center;
  padding: 30px;
  height: 330px;
  border-radius: 10px;
  box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
  > span {
    font-size: 25px;
    font-weight: 700;
    text-align: left;
    margin-right: 350px;
  }
  span:nth-of-type(2) {
    margin-right: 270px;
  }
  input {
    height: 40px;
    font-size: 18px;
    color: #363b3f;
    text-indent: 15px;
    margin-bottom: 20px;
    border: 1px solid #d5d7d9;
    border-radius: 5px;
    width: 380px;
  }
  input:focus {
    border: 1px solid cornflowerblue;
    border-radius: 2px;
    outline: none;
    box-shadow: 0 0 0 5px #cde9fe;
  }
  button {
    font-size: 18px;
    width: 380px;
  }
`;
const SignupBox = styled.div`
  margin-top: 50px;
  display: flex;
  width: 250px;
  justify-content: space-around;
  p {
    font-size: 18px;
  }
  span {
    font-size: 18px;
    color: #3b79c8;
    margin-left: 10px;
    text-decoration: none;
  }
`;
const BtnWrapper = styled.div`
  margin-bottom: 30px;
  position: relative;
  button {
    color: #44484c;
    border: 1px solid #d7d9dc;
    width: 450px;
    font-size: 18px;
  }
  .gglogo {
    position: absolute;
    right: 310px;
    top: 15px;
  }
`;
