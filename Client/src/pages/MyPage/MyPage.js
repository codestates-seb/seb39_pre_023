import Nav from '../../components/Nav';
import MyContent from '../../components/MyContent';
import MyInfo from '../../components/MyInfo';
import styled from 'styled-components';
import { useState, useEffect } from 'react';
import axios from 'axios';
axios.defaults.withCredentials = false;

const Container = styled.div`
  display: flex;
`;
const MypageContainer = styled.div`
  display: flex;
  flex-direction: column;
`;
const MyPage = () => {
  const [nickname, setNickname] = useState('');
  const [location, setLocation] = useState('');
  const [about, setAbout] = useState('');
  const [answers, setAnswers] = useState([]);
  const [questions, setQuestions] = useState([]);
  const [InfoData, setInfoData] = useState({});
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios
      .get('http://3.39.180.45:56178/DBtest/getProfile?member_id=2')
      .then((res) => {
        setInfoData(res.data);
        setNickname(res.data.displayname);
        setLocation(res.data.location);
        setAbout(res.data.about);
      });
    axios.get(`http://3.39.180.45:56178/DBtest/findPost/2`).then((res) => {
      setQuestions(res.data.content);
      console.log(res.data.content);
    });
    axios.get(`http://3.39.180.45:56178/DBtest/findAnswers/2`).then((res) => {
      setAnswers(res.data.data);
      console.log(res.data.data);
      setLoading(false); //아직 더미X
    });
  }, []);
  if (loading) return null;

  return (
    <Container>
      <Nav />
      <MypageContainer>
        <MyInfo
          nickname={InfoData.displayname}
          location={InfoData.location}
          signupDate={InfoData.sign_in_date}
        />
        <MyContent
          reputation={InfoData.stub_reputation}
          reached={InfoData.stub_reached}
          answers={answers}
          questions={questions}
          about={about}
          setAbout={setAbout}
          nickname={nickname}
          setNickname={setNickname}
          location={location}
          setLocation={setLocation}
        />
      </MypageContainer>
    </Container>
  );
};

export default MyPage;
