import { Routes, Route } from 'react-router-dom';
import './App.css';
import MyFooter from './components/MyFooter';
import MyHeader from './components/MyHeader';
import Nav from './components/Nav';
import MyPage from './pages/MyPage/MyPage';
import EditQuestion from './pages/Question/EditQuestion';
import PostQuestion from './pages/Question/PostQuestion';
import QuestionDetail from './pages/Question/QuestionDetail';
import QuestionList from './pages/Question/QuestionList';
import Login from './pages/Sign/Login';
import Logout from './pages/Sign/Logout';
import SignUp from './pages/Sign/SingUp';

function App() {
  return (
    <div className="App">
      <MyHeader />
      <Nav />
      <Routes>
        <Route path="/" element={<QuestionList />} />
        <Route path="/login" element={<Login />} />
        <Route path="/logout" element={<Logout />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/mypage" element={<MyPage />} />
        <Route path="/questiondetail/:id" element={<QuestionDetail />} />
        <Route path="/questionedit/:id" element={<EditQuestion />} />
        <Route path="/questionwrite" element={<PostQuestion />} />
      </Routes>
      <MyFooter />
    </div>
  );
}

export default App;
