import { Fragment, useEffect, useState } from 'react';
import styled from 'styled-components';
import Nav from '../../components/Nav';
import MyButton from '../../components/MyButton';
import { useNavigate, Link } from 'react-router-dom';
import MyFooter from '../../components/MyFooter';
import axios from 'axios';
import DeleteModal from '../../components/DeleteModal';
import PostBodyTextarea from '../../components/PostBodyTextarea';

/* eslint-disable react/prop-types */
/* eslint-disable react/jsx-key */
const HeaderRow = styled.div`
  display: flex;
  justify-content: space-between;
  width: 1000px;
  height: 100px;
  padding: 30px 30px;
  padding-bottom: 0px;
`;

const StyledHeader = styled.header`
  display: flex;
  padding-bottom: 10px;
  margin-bottom: 5px;
  h1 {
    margin-bottom: -16px;
    padding-bottom: 3px;
  }
`;

const StyledAnswerHeader = styled.h2`
  font-size: 1.6rem;
  padding-top: 10px;
  padding-left: 30px;
  padding-bottom: 5px;
`;

const BtnWrapper = styled.div`
  height: 200px;
  width: 150px;
  padding-left: 30px;
`;

const StyledMain = styled.main`
  display: flex;
  @import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');
  font-family: Roboto, sans-serif;
`;

const MainWrapper = styled.div`
  display: flex;
  flex-direction: column;
`;

const StatusBar = styled.div`
  display: flex;
  border-bottom: 1px solid lightgray;
  padding-bottom: 15px;
  margin-top: 0px;
  padding-left: 30px;
  color: gray;
  p {
    padding-right: 10px;
  }
`;

const StyledComment = styled.button`
  color: blue;
  padding-left: 30px;
  padding-bottom: 10px;
  border: none;
  background-color: white;
`;

const Linkbar = styled.div`
  padding-left: 30px;
  padding-bottom: 50px;
  a {
    padding-right: 10px;
    text-decoration-line: none;
    color: blue;
  }
  button {
    border: none;
    color: blue;
    background-color: white;
    padding-right: 10px;
    font-size: 1rem;
  }
`;

const Info = styled.div`
  padding-top: 40px;
  padding-left: 30px;
  padding-bottom: 3px;
  border-bottom: 1px solid lightgray;
`;

const DetailBody = styled.div`
  padding-left: 20px;
  padding-top: 20px;
`;

const ColumnDivide = styled.div`
  display: flex;
`;

const PostBodyTextareaWrapper = styled.div`
  padding-left: 30px;
`;

const CommentOutter = styled.div`
  padding-left: 10px;
  border-top: 1px solid rgba(255, 255, 255, 0.1);
`;

const CommentBox = styled.div`
  border-bottom: 1px solid rgba(255, 255, 255, 0.1);
  padding: 20px;
  font-size: 0.8rem;
`;

const StyledTextarea = styled.textarea`
  background: none;
  border: 1px solid #777;
  border-radius: 3px;
  display: block;
  width: 97%;
  box-sizing: border-box;
  margin-bottom: 20px;
  margin-left: 30px;
  color: #fff;
`;

const AnswerWrapper = styled.div`
  padding-left: 30px;
  padding-top: 10px;
  padding-bottom: 10px;
`;

const AnswerBtnWrapper = styled.div`
  button {
    border: none;
    color: red;
    background-color: white;
    padding-right: 10px;
    font-size: 1rem;
    padding-left: 30px;
  }
`;

const CommentBtnWrapper = styled.div`
  button {
    border: none;
    color: red;
    background-color: white;
    padding-right: 10px;
    font-size: 1rem;
    padding-left: 30px;
  }
`;

const QuestionDetail = () => {
  const [question, setQuestion] = useState({});
  const [deleteModal, setDeleteModal] = useState(false);
  const [answerBody, setAnswerBody] = useState('');
  const [answerComments, setAnswerComments] = useState([]);
  const [showCommentForm, setShowCommentForm] = useState(false);
  // const [showButton, setShowButton] = useState(false);
  const [answers, setAnswers] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getQuestion();
    getAnswers();
  }, []);

  function getQuestion() {
    axios
      .get(`http://3.39.180.45:56178/DBtest/getPost?post_id=1`)
      .then((res) => {
        const data = res.data.post;
        setQuestion({ ...data });
        console.log(data);
      });
  }

  function getComments() {
    axios.get('http://3.39.180.45:56178/api/comment/answer/2').then((res) => {
      setAnswerComments(res.data);
      console.log('코맨트리스트성공', res.data);
    });
  }

  function postAnswer(ev) {
    ev.preventDefault();
    axios
      .post(`http://3.39.180.45:56178/DBtest/createAnswer`, {
        post_id: answers.answer_id,
        member_id: '2',
        content: answers.content,
      })
      .then((res) => {
        console.log(res);
        setAnswerBody('');
        setAnswers(res.data.data);
        console.log('답변작성성공', res.data.data);
      });
  }

  function getAnswers() {
    axios
      .get('http://3.39.180.45:56178/DBtest/findAnswers/1?page=1&size=15')
      .then((res) => {
        setAnswers(res.data.data);
        getComments();
        console.log('답변받는데성공', res.data.data);
      });
  }

  function postAnswerComment(ev) {
    ev.preventDefault();
    axios
      .post(`http://3.39.180.45:56178/api/comment/answer/1`, {
        content: answerComments.content,
        answer_id: answerComments.comment.id,
      })
      .then((res) => {
        console.log('댓글데이터', res);
        console.log('답변댓글성공', res.data);
      });
  }
  const deleteAnswer = () => {
    axios
      .delete(`http://3.39.180.45:56178/DBtest/deleteAnswer/1`)
      .then((res) => {
        console.log(res);
        console.log('답변삭제 성공');
      })
      .catch((err) => console.log(err, 'Error'));
  };

  const deleteComment = () => {
    axios
      .delete(`http://3.39.180.45:56178/api/comment/`)
      .then((res) => {
        console.log(res);
        console.log('코멘트삭제 성공');
      })
      .catch((err) => console.log(err, 'Error'));
  };

  return (
    <Fragment>
      <StyledMain>
        <Nav />
        <MainWrapper>
          <HeaderRow>
            <StyledHeader>
              <h1>{question.post_name}</h1>
            </StyledHeader>
            <BtnWrapper>
              <MyButton
                text={`Ask Question`}
                type={'blue'}
                onClick={() => {
                  navigate('/questionwrite');
                }}
              />
            </BtnWrapper>
          </HeaderRow>
          <StatusBar>
            <p>Asked: {question.write_date}</p>
            <p>Modified: {question.modified_date}</p>
            <p>Viewed {question.view_count} times</p>
          </StatusBar>
          <ColumnDivide>
            <DetailBody>{question.post_content}</DetailBody>
          </ColumnDivide>

          <Linkbar>
            <button
              onClick={() => {
                setDeleteModal(true);
              }}
            >
              delete
            </button>
            <Link to={`/questionedit`} state={{ question: question }}>
              edit
            </Link>
          </Linkbar>
          <Info>
            Know someone who can answer? Share a link to this question via
            email, Twitter, or Facebook.
          </Info>
          {answers.map((answer) => (
            <AnswerWrapper>{answer.content}</AnswerWrapper>
          ))}

          <AnswerBtnWrapper>
            <MyButton
              text={`delete`}
              type={'red'}
              onClick={(e) => {
                deleteAnswer(e);
              }}
            />
          </AnswerBtnWrapper>

          <CommentOutter>
            {answerComments &&
              answerComments.length > 0 &&
              answerComments.map((answerComment) => (
                <CommentBox>{answerComment.content}</CommentBox>
              ))}
            <CommentBtnWrapper>
              <MyButton
                text={`delete`}
                type={'red'}
                onClick={(e) => {
                  deleteComment(e);
                }}
              />
            </CommentBtnWrapper>
            {showCommentForm && (
              <StyledTextarea
                type="text"
                value={answerComments}
                onChange={(e) => {
                  setAnswerComments(e.target.value);
                }}
              ></StyledTextarea>
            )}
            {!showCommentForm && (
              <StyledComment
                onClick={(e) => {
                  setShowCommentForm(true);
                  postAnswerComment(e);
                }}
              >
                Add comment
              </StyledComment>
            )}
          </CommentOutter>
          <StyledAnswerHeader>Your Answer</StyledAnswerHeader>
          <PostBodyTextareaWrapper>
            <PostBodyTextarea
              value={answerBody}
              handlePostBodyChange={(value) => setAnswerBody(value)}
            />
          </PostBodyTextareaWrapper>
          <BtnWrapper>
            <MyButton
              text={`Post Your Answer`}
              type={'blue'}
              onClick={(e) => {
                postAnswer(e);
              }}
            />
          </BtnWrapper>
        </MainWrapper>
      </StyledMain>
      {deleteModal ? (
        <DeleteModal
          deleteModal={deleteModal}
          setDeleteModal={setDeleteModal}
        />
      ) : null}

      <MyFooter />
    </Fragment>
  );
};

export default QuestionDetail;
