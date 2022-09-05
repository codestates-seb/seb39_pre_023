import { Fragment, useState } from 'react';
import Nav from '../../components/Nav';
import styled from 'styled-components';
import MyButton from '../../components/MyButton';
import { useNavigate, Link, useLocation } from 'react-router-dom';
import axios from 'axios';
import gfm from 'remark-gfm';
import ReactMarkdown from 'react-markdown';
import { getLoginCookie } from '../../lib/cookie';

const PostContainer = styled.div`
  @import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');
  font-family: Roboto, sans-serif;
  display: flex;
  flex-direction: column;
  background-color: white;
  margin-left: 30px;
  padding: 30px 30px 30px;
  width: 876px;
  height: 587.17px;
  border-radius: 10px;
  position: center;
  box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
  h3 {
    font-weight: 600;
  }
`;

const QuestionTitleInput = styled.input`
  background: none;
  border: 1px solid #777;
  border-radius: 3px;
  display: block;
  width: 100%;
  box-sizing: border-box;
  padding: 10px;
  margin-bottom: 20px;
  h3 {
    font-weight: 600;
  }
`;

const QuestionBodyTextarea = styled.textarea`
  background: none;
  border: 1px solid #777;
  border-radius: 3px;
  display: block;
  width: 100%;
  box-sizing: border-box;
  padding-bottom: 20px;
  height: 200px;
  margin-bottom: 20px;
  h3 {
    font-weight: 600;
  }
`;

const PreviewArea = styled.div`
  padding: 20px;
  background-color: #f8f9f8;
  border-radius: 5px;
  margin-bottom: 20px;
`;

const QuestionTagInput = styled.input`
  background: none;
  border: 1px solid #777;
  border-radius: 3px;
  display: block;
  width: 100%;
  box-sizing: border-box;
  padding: 10px;
  margin-bottom: 20px;
  h3 {
    font-weight: 100;
  }
`;

const Container = styled.div`
  @import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');
  font-family: Roboto, sans-serif;
  display: flex;
`;

const StyledForm = styled.div`
  padding-top: 10px;
  padding-bottom: 30px;
`;

const ButtonRow = styled.div`
  display: flex;
  margin-left: 30px;
`;

const StyledBody = styled.div`
  display: flex;
  flex-direction: column;
`;

const StyledLink = styled.div`
  font-size: 17px;
  display: flex;
  justify-content: center;
  align-items: center;
  padding-left: 20px;
  a {
    text-decoration-line: none;
    color: blue;
  }
`;

const EditQuestion = () => {
  const location = useLocation();
  const data = location.state.detail;
  console.log(data);
  const [title, setTitle] = useState(data.post_name);
  console.log(data.post_name);
  const [body, setBody] = useState(data.post_content);
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();
    axios
      .put(
        'http://3.39.180.45:56178/DBtest/update/1',
        {
          post_name: title,
          post_content: body,
          member_id: '2',
          tags: ['java', 'java2'],
        },
        { headers: { Authorization: getLoginCookie() } }
      )
      .then((res) => {
        console.log(res.data);
        console.log('글수정 성공');
        navigate('/questiondetail');
      })
      .catch((err) => {
        console.log(err);
      });
  };
  return (
    <Fragment>
      <Container>
        <Nav />
        <StyledBody>
          <StyledForm>
            <PostContainer>
              <h3>Title</h3>
              <div>
                Be specific and imagine you &apos; re asking a question to
                another person
              </div>
              <QuestionTitleInput
                defaultValue={title}
                onChange={(e) => setTitle(e.target.value)}
                type="text"
                placeholder="e.g Is there an R function for finding the index of an element in a vector?"
              />
              <h3>Body</h3>
              <span>
                Include all the information someone would need to answer your
                question
              </span>
              <QuestionBodyTextarea
                defaultValue={body}
                onChange={(e) => setBody(e.target.value)}
              />
              <PreviewArea>
                <ReactMarkdown plugins={[gfm]}>{body}</ReactMarkdown>
              </PreviewArea>
              <h3>Tag Name</h3>
              <span>
                Add up to 5 tags to describe what your question is about
              </span>
              <QuestionTagInput type="text" />
            </PostContainer>
          </StyledForm>
          <ButtonRow>
            <MyButton
              text={`Save edits`}
              type={'blue'}
              onClick={(event) => handleSubmit(event)}
            />
            <StyledLink>
              <Link to="/questiondetail">cancel</Link>
            </StyledLink>
          </ButtonRow>
        </StyledBody>
      </Container>
    </Fragment>
  );
};

export default EditQuestion;
