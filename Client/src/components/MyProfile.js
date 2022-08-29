import styled from 'styled-components';

const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: 1070px;
  margin-top: 30px;
  .title {
    font-size: 25px;
    font-weight: 600;
  }
  .container {
    display: flex;
    flex-direction: row;
    border: 1px solid lightgray;
    border-radius: 5px;
  }
`;
const StatsWrapper = styled.div`
  display: flex;
  flex-direction: column;
  width: 410px;
  .statsWrapper {
    display: flex;
    flex-direction: column;
    margin: 20px;
  }
`;

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 30px;
  .box {
    border: 1px solid lightgray;
    border-radius: 5px;
    min-height: 100px;
    margin-top: 10px;
    padding-top: 20px;
    padding-left: 20px;
  }
  .listbox {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding-bottom: 20px;
  }
  /* 질문, 답변 리스트 존재할때 css 처리해줘야함 */
`;

const MyProfile = () => {
  const answers = [];
  const questions = [];
  return (
    <Container>
      <StatsWrapper className="statsBox">
        <div className="title">Stats</div>
        <div className="container">
          <div className="statsWrapper">
            <div className="score">1</div>
            <div>reputation</div>
          </div>
          <div className="statsWrapper">
            <div className="score">0</div>
            <div>reached</div>
          </div>
          <div className="statsWrapper">
            <div className="score">0</div>
            <div>answers</div>
          </div>
          <div className="statsWrapper">
            <div className="score">0</div>
            <div>questions</div>
          </div>
        </div>
      </StatsWrapper>
      <Wrapper>
        <div className="title">About</div>
        <div className="box">hello world</div>
      </Wrapper>
      <Wrapper>
        <div className="title">0 Answers</div>
        {/* answers 배열 길이 0 이면 "you have not...." */}
        <div className={answers.length === 0 ? 'box listbox' : 'box'}>
          {answers.length === 0 ? (
            <div>you have not answered any questions</div>
          ) : (
            <div></div>
          )}
        </div>
      </Wrapper>
      <Wrapper>
        <div className="title">0 questions</div>
        <div className={questions.length === 0 ? 'box listbox' : 'box'}>
          {questions.length == 0 ? (
            <div>you have not asked any questions</div>
          ) : (
            <div></div>
          )}
        </div>
      </Wrapper>
    </Container>
  );
};

export default MyProfile;
