import { useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import './App.css';
import MyHeader from './components/MyHeader';
import HeaderModal from './components/HeaderModal';
import MyPage from './pages/MyPage/MyPage';
import EditQuestion from './pages/Question/EditQuestion';
import PostQuestion from './pages/Question/PostQuestion';
import QuestionDetail from './pages/Question/QuestionDetail';
import QuestionList from './pages/Question/QuestionList';
import Login from './pages/Sign/Login';
import Logout from './pages/Sign/Logout';
import SignUp from './pages/Sign/SingUp';

function App() {
  const [viewModal, setModal] = useState(false);
  return (
    <div className="App">
      <MyHeader viewModal={viewModal} setModal={setModal} />
      {viewModal ? (
        <HeaderModal viewModal={viewModal} setModal={setModal} />
      ) : null}
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
    </div>
  );
}

export default App;
