import Nav from '../../components/Nav';
import MyContent from '../../components/MyContent';
import MyInfo from '../../components/MyInfo';
import styled from 'styled-components';

const Container = styled.div`
  display: flex;
`;
const MypageContainer = styled.div`
  display: flex;
  flex-direction: column;
`;
const MyPage = () => {
  return (
    <Container>
      <Nav />
      <MypageContainer>
        <MyInfo />
        <MyContent />
      </MypageContainer>
    </Container>
  );
};

export default MyPage;
