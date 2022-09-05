import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import MyButton from '../../components/MyButton';

const Logout = () => {
  const navigate = useNavigate();
  return (
    <Container>
      <LogoutBox>
        <BoxWrapper>
          <BtnContainer>
            <MyButton text={'Log out'} type={'blue'} onClick={() => {}} />
            <MyButton
              text={'Cancel'}
              type={'skyblue'}
              onClick={() => {
                navigate('/');
              }}
            />
          </BtnContainer>
          <Pcontainer>
            <p>
              If you&apos;re on a shared computer, remember to log out of your
              Open ID provider (Facebook, Google, Stack Exchange, etc.) as well.
            </p>
          </Pcontainer>
        </BoxWrapper>
      </LogoutBox>
    </Container>
  );
};

export default Logout;

const Container = styled.div`
  background-color: #f1f2f3;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
`;
const LogoutBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 450px;
  height: 550px;
`;
const BoxWrapper = styled.div`
  display: flex;
  flex-direction: column;
  background-color: white;
  justify-content: center;
  align-items: center;
  padding: 30px;
  height: 330px;
  border-radius: 10px;
  box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
`;
const BtnContainer = styled.div`
  display: flex;
  width: 400px;
  justify-content: space-around;
  button {
    width: 150px;
    margin: 10px;
    font-size: 18px;
  }
`;
const Pcontainer = styled.div`
  width: 400px;
  p {
    margin-top: 30px;
    padding: 0px 20px;
    color: #7a8189;
    width: 400px;
    font-size: 18px;
  }
`;
