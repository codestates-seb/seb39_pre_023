import { Fragment, useState, useEffect } from 'react';
import Nav from '../../components/Nav';
import styled from 'styled-components';
import MyButton from '../../components/MyButton';
import { useNavigate, Link, useLocation } from 'react-router-dom';
import axios from 'axios';
import gfm from 'remark-gfm';
import ReactMarkdown from 'react-markdown';
import { getLoginCookie } from '../../lib/cookie';
import Tags from '../../components/Tags';

const EditQuestion = () => {
  const location = useLocation();
  const data = location.state.data;

  const [title, setTitle] = useState(data.post_name);

  const [body, setBody] = useState(data.post_content);
  const navigate = useNavigate();
  const [tagList, setTagList] = useState([]);
  const [tags, setTags] = useState([]);
  const [tagData, setTagData] = useState([...data.tags]);
  const [msg, setMsg] = useState(<p></p>);

  useEffect(() => {
    axios.get(`http://3.39.180.45:56178/DBtest/tagFinds`).then((res) => {
      setTagList(res.data.tags);
    });
  }, []);

  useEffect(() => {
    setTagData(tags.map((el) => el.name));
  }, [tags]);

  const handleSubmit = (event) => {
    event.preventDefault();
    for (let i = 0; i < tagData.length; i++) {
      if (tagData[0] === '') {
        setMsg(<p>Please check your title or body.. Some data is missing.</p>);
      } else if (title === '' || body === '') {
        setMsg(<p>Please check your title or body.. Some data is missing.</p>);
      } else {
        setMsg(<p></p>);
        axios
          .put(
            `http://3.39.180.45:56178/DBtest/update/${data.post_id}`,
            {
              post_name: title,
              post_content: body,
              member_id: data.writer.member_id,
              tags: tagData,
            },
            { headers: { Authorization: getLoginCookie() } }
          )
          .then((res) => {
            console.log(res.data);
            console.log('글수정 성공');
            navigate(`/questiondetail/${data.post_id}`);
          })
          .catch((err) => {
            console.log(err);
          });
      }
    }
  };
  return (
    <Fragment>
      <Container>
        <Nav />
        <StyledBody>
          <StyledForm>
            <PostContainer>
              <h1>Edit Your Question</h1>
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

              <Tags tagList={tagList} tags={tags} setTags={setTags} />
              {msg}
            </PostContainer>
          </StyledForm>

          <ButtonRow>
            <MyButton
              text={`Save edits`}
              type={'blue'}
              onClick={(event) => handleSubmit(event)}
            />
            <StyledLink>
              <Link to={`/questiondetail/${data.post_id}`}>cancel</Link>
            </StyledLink>
          </ButtonRow>
        </StyledBody>
      </Container>
    </Fragment>
  );
};

export default EditQuestion;
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

  h1 {
    margin-bottom: 20px;
    border-bottom: 1px lightgray solid;
    padding-bottom: 10px;
  }
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

// const QuestionTagInput = styled.input`
//   background: none;
//   border: 1px solid #777;
//   border-radius: 3px;
//   display: block;
//   width: 100%;
//   box-sizing: border-box;
//   padding: 10px;
//   margin-bottom: 20px;
//   h3 {
//     font-weight: 100;
//   }
// `;

const Container = styled.div`
  @import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');
  font-family: Roboto, sans-serif;
  display: flex;
`;

const StyledForm = styled.div`
  padding-top: 10px;
  padding-bottom: 30px;
  border-left: 1px solid #cccdce;
  height: 100vh;
`;

const ButtonRow = styled.div`
  display: flex;
  margin-left: 60px;
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
    color: #066ac8;
    width: 120px;
    height: 35px;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
  }
  a:hover {
    background-color: #e3e6e8;
    transition: 0.5s;
  }
`;
