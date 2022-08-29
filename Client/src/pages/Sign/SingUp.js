import { Link } from 'react-router-dom';
import styled from 'styled-components';
import MyButton from '../../components/MyButton';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
// import { faGoogle } from '@fortawesome/fontawesome-free-brands';
import {
  faQuestionCircle,
  faCheckToSlot,
  faBookmark,
  faTrophy,
} from '@fortawesome/free-solid-svg-icons';
const SignUp = () => {
  return (
    <Container>
      <MsgContatiner>
        <p className="title">Join the Stack Overflow community</p>
        <SentenceContatiner>
          <div>
            <FontAwesomeIcon icon={faQuestionCircle} className="icon" />
            <span className="sentence">Get unstuck — ask a question</span>
          </div>
          <div>
            <FontAwesomeIcon icon={faCheckToSlot} className="icon" />
            <span className="sentence">
              Unlock new spanrivileges like voting and commenting
            </span>
          </div>
          <div>
            <FontAwesomeIcon icon={faBookmark} className="icon" />
            <span className="sentence">
              Save your favorite tags, filters, and jobs
            </span>
          </div>
          <div>
            <FontAwesomeIcon icon={faTrophy} className="icon" />
            <span className="sentence">Earn reputation and badges</span>
          </div>
        </SentenceContatiner>
        <p className="footer">
          Collaborate and share knowledge with a private group for FREE.
          <br />
          Get Stack Overflow for Teams free for up to 50 users.
        </p>
      </MsgContatiner>
      <SignupContainer>
        <BtnWrapper>
          {/* <FontAwesomeIcon icon={faGoogle} className="gglogo" /> */}
          <MyButton
            text={'Sign up with Google'}
            type={'default'}
            onClick={() => {}}
          />
        </BtnWrapper>
        <SignupBox>
          <span>Id</span>
          <input type="text"></input>
          <MyButton text={'ID check'} onClick={() => {}} type={'orange'} />
          <span>Password</span>
          <input type="password"></input>
          <span>Password check</span>
          <input type="password"></input>
          <p>
            Passwords must contain at least eight characters, including at least
            1 letter and 1 number.
          </p>
          <MyButton text={'Sign up'} type={'blue'} onClick={() => {}} />
          <p>
            By clicking “Sign up”, you agree to our terms of service, privacy
            policy and cookie policy
          </p>
        </SignupBox>
        <LoginBox>
          <p>
            Already have an account?
            <Link to="/login">
              <span className="loginbtn">Log in</span>
            </Link>
          </p>
        </LoginBox>
      </SignupContainer>
    </Container>
  );
};

export default SignUp;

const Container = styled.div`
  background-color: #f1f2f3;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
`;
const MsgContatiner = styled.div`
  margin-right: 40px;
  height: 300px;
  .title {
    font-size: 25px;
    margin-bottom: 10px;
  }
  .sentence {
    font-size: 16px;
    margin-left: 10px;
    color: #4c4e51;
  }
  .footer {
    font-size: 14px;
    color: #6c757e;
  }
  .icon {
    color: #2a89fe;
  }
`;
const SentenceContatiner = styled.div`
  display: flex;
  flex-direction: column;
  height: 200px;
  justify-content: space-around;
`;
const SignupContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 700px;
`;
const SignupBox = styled.div`
  display: flex;
  flex-direction: column;
  background-color: white;
  justify-content: center;
  align-items: center;
  padding: 30px;
  width: 315px;
  height: 450px;
  border-radius: 10px;
  position: relative;
  box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
  input:first-of-type {
  }
  button:first-of-type {
    width: 58px;
    position: absolute;
    top: 48px;

    left: 240px;
    font-size: 12px;
    height: 35px;
    border: none;
  }
  > span {
    font-size: 16px;
    font-weight: 700;
    text-align: left;
    margin-right: 260px;
    margin-bottom: 5px;
  }
  span:nth-of-type(2) {
    margin-right: 210px;
  }
  span:nth-of-type(3) {
    margin-right: 180px;
    width: 100px;
    white-space: nowrap;
  }
  input {
    height: 35px;
    font-size: 14px;
    color: #363b3f;
    text-indent: 15px;
    margin-bottom: 10px;
    border: 1px solid #d5d7d9;
    border-radius: 5px;
    width: 280px;
  }
  input:focus {
    border: 1px solid cornflowerblue;
    border-radius: 2px;
    outline: none;
    box-shadow: 0 0 0 5px #cde9fe;
  }
  button {
    font-size: 14px;
    width: 280px;
    margin: 20px 0;
  }
  p {
    color: #7f868d;
    font-size: 14px;
    width: 280px;
  }
`;
const LoginBox = styled.div`
  margin-top: 50px;
  display: flex;
  width: 250px;
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
    width: 315px;
    height: 38px;
    font-size: 14px;
  }
  .gglogo {
    position: absolute;
    right: 230px;
    top: 12px;
  }
`;
