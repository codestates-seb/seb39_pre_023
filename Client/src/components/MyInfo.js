import styled from 'styled-components';

// 부모컴포에서 img Sr, displayname, 가입일, location만 내려받기
const MyInfo = () => {
  return (
    <Container>
      <Left>
        <img
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9aJlhtrVx_GZ35lZySYo5SwodOhVxwCbIhg&usqp=CAU"
          className="profileImage"
          alt="profileImage"
        ></img>
      </Left>
      <Right>
        <div className="displayname">doyeondo</div>
        <div className="signupdate">Member for 6 days</div>
        <div className="location">south korea</div>
      </Right>
    </Container>
  );
};

export default MyInfo;

const Container = styled.div`
  display: flex;
  width: 1070px;
  height: 150px;
  margin-top: 20px;
  margin-left: 20px;
`;
const Left = styled.div`
  display: flex;
  img {
    width: 130px;
    height: 130px;
    margin-right: 20px;
    border-radius: 5px;
  }
`;
const Right = styled.div`
  display: flex;
  flex-direction: column;
  font-size: 14px;
  color: gray;
  font-weight: 400;
  margin-top: 5px;
  .displayname {
    font-size: 35px;
    font-weight: 600;
    color: black;
    margin-top: 10px;
    margin-bottom: 40px;
  }
`;
