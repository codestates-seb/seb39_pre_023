import styled from 'styled-components';
import MyListItem from './MyListItem';
import MyAnswerListItem from './MyAnswerListitem';
/* eslint-disable react/prop-types */
import axios from 'axios';
axios.defaults.withCredentials = false;
const MyProfile = ({ answers, questions, reputation, reached, about }) => {
  return (
    <Container>
      <StatsWrapper className="statsBox">
        <div className="title">Stats</div>
        <div className="container">
          <div className="statsWrapper">
            <div className="score">{reputation}</div>
            <div>reputation</div>
          </div>
          <div className="statsWrapper">
            <div className="score">{reached}</div>
            <div>reached</div>
          </div>
          <div className="statsWrapper">
            <div className="score">{answers.length}</div>
            <div>answers</div>
          </div>
          <div className="statsWrapper">
            <div className="score">{questions.length}</div>
            <div>questions</div>
          </div>
        </div>
      </StatsWrapper>
      <Wrapper>
        <div className="title">About</div>
        <div className="box">{about}</div>
      </Wrapper>
      <Wrapper>
        <div className="title">{answers.legnth}Answers</div>
        <div className={answers.length === 0 ? 'box listbox' : 'box'}>
          {answers.length === 0 ? (
            <div>You have not answered any questions.</div>
          ) : (
            <>
              {answers.map((el) => {
                const date = new Date(
                  String(el.modified_date)
                ).toLocaleDateString();
                return (
                  <MyAnswerListItem
                    key={el.answer_id}
                    title={el.content}
                    date={date}
                    accepted={el.accepted}
                    linkId={el.answer_id}
                  />
                );
              })}
            </>
          )}
        </div>
      </Wrapper>
      <Wrapper>
        <div className="title">{questions.legnth}questions</div>
        <div className={questions.length === 0 ? 'box listbox' : 'box'}>
          {questions.length == 0 ? (
            <div>You have not asked any questions.</div>
          ) : (
            <>
              {questions.map((el) => {
                const date = new Date(
                  String(el.modified_date)
                ).toLocaleDateString();
                return (
                  <MyListItem
                    key={el.post_id}
                    title={el.post_name}
                    content={el.post_content}
                    date={date}
                    linkId={el.post_id}
                  />
                );
              })}
            </>
          )}
        </div>
      </Wrapper>
    </Container>
  );
};

export default MyProfile;

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
    padding-bottom: 10px;
  }
  .listbox {
    display: flex;
    justify-content: center;
    align-items: center;
  }
`;
