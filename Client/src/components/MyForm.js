import styled from 'styled-components';

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
`;

const QuestionBodyTextarea = styled.textarea`
  background: none;
  border: 1px solid #777;
  border-radius: 3px;
  display: block;
  width: 100%;
  box-sizing: border-box;
  padding: 10px;
  min-height: 200px;
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
`;
const MyForm = () => {
  return (
    <PostContainer>
      <h3>Title</h3>
      <div>
        Be specific and imagine you &apos; re asking a question to another
        person
      </div>
      <QuestionTitleInput
        type="text"
        placeholder="e.g Is there an R function for finding the index of an element in a vector?"
      />
      <h3>Body</h3>
      <span>
        Include all the information someone would need to answer your question
      </span>
      <QuestionBodyTextarea />
      <h3>Tag Name</h3>
      <span>Add up to 5 tags to describe what your question is about</span>
      <QuestionTagInput type="text" />
    </PostContainer>
  );
};

export default MyForm;
