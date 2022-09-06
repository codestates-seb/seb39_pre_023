/* eslint-disable react/prop-types */
import axios from 'axios';
import { useState } from 'react';
import styled from 'styled-components';
import AnswerVote from './AnswerVote';
import { getLoginCookie } from '../lib/cookie';
import { useSelector } from 'react-redux';
const AnswerItem = ({ data, pid }) => {
  // console.log(data);
  const state = useSelector((state) => state.signInReducer);
  const userData = localStorage.getItem('userData');
  let userinfo = JSON.parse(userData);
  let memberid = userinfo.memberId;
  const [content, setContent] = useState(data.content);
  let aid = data.answer_id;
  const [isEdit, setIsEdit] = useState(false);
  const [votes, setVotes] = useState(0);
  const createdAt = new Date(data.create_date).toLocaleDateString('en-us', {
    hour: 'numeric',
    minute: 'numeric',
  });
  const deleteAnswer = () => {
    axios
      .delete(
        `http://3.39.180.45:56178/DBtest/deleteAnswer/${data.answer_id}`,
        {
          headers: { Authorization: getLoginCookie() },
        }
      )
      .then((res) => {
        console.log(res.data);
        console.log('답변 삭제성공');
      });
  };
  const editAnswer = () => {
    const putForm = {
      post_id: pid,
      member_id: memberid,
      content: content,
    };
    axios
      .put(
        `http://3.39.180.45:56178/DBtest/updateAnswer/${data.answer_id}`,
        putForm,
        { headers: { Authorization: getLoginCookie() } }
      )
      .then((res) => {
        console.log(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };
  const onIncreaseVote = () => {
    let data = {};
    axios
      .post(
        `http://3.39.180.45:56178/DBtest/answer_vote?vote=+1&member_id=${memberid}&answer_id=${aid}`,
        data,
        { headers: { Authorization: getLoginCookie() } }
      )
      .then(() => {
        setVotes(votes + 1);
      });
  };
  const onDecreaseVote = () => {
    axios
      .post(
        `http://3.39.180.45:56178/DBtest/answer_vote?vote=-1&member_id=${memberid}&answer_id=${aid}`,
        data,
        { headers: { Authorization: getLoginCookie() } }
      )
      .then(() => {
        setVotes(votes - 1);
      });
  };
  console.log(data);
  return (
    <>
      <Container>
        <div className="left">
          <AnswerVote
            onIncreaseVote={onIncreaseVote}
            onDecreaseVote={onDecreaseVote}
            votes={votes}
          />
        </div>
        <div className="right">
          <div className="content">
            <div>{data.content}</div>
          </div>
          <div className="content-bottom">
            <div className="btns">
              {state.loginState &&
              parseInt(memberid) === parseInt(data.member_id) ? (
                <>
                  <button onClick={() => setIsEdit(true)}>Edit</button>
                  <button onClick={() => deleteAnswer()}>Delete</button>
                </>
              ) : null}
            </div>
            <div className="userinfo">
              <span>Answered </span>
              <br />
              <span>{createdAt}</span>
              <p className="name">{data.id}</p>
            </div>
          </div>
          {isEdit ? (
            <>
              <input
                defaultValue={content}
                onChange={(e) => setContent(e.target.value)}
              ></input>
              <button onClick={editAnswer}>수정하기</button>
              <button onClick={() => setIsEdit(false)}>취소</button>
            </>
          ) : null}
        </div>
      </Container>
    </>
  );
};

export default AnswerItem;
const Container = styled.div`
  display: flex;
  width: 1070px;
  align-items: flex-start;
  border-bottom: 1px solid lightgray;
  .right {
    margin-left: 10px;
    padding: 10px;
    width: 1070px;
  }
  .content {
    min-height: 50px;
  }
  .content-bottom {
    width: 1030px;
    display: flex;
    justify-content: space-between;
    font-size: 14px;
    font-weight: 400;
    button {
      background-color: transparent;
      border: none;
      color: gray;
      margin-right: 7px;
      cursor: pointer;
    }
    a {
      text-decoration: none;
      color: gray;
      margin-right: 7px;
      cursor: pointer;
    }
    .userinfo {
      span {
        color: #a4a4a4;
      }
    }
    .name {
      color: #0a95ff;
      margin-left: 5px;
      cursor: pointer;
    }
  }
`;
