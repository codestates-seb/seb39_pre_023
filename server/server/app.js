import cors from 'cors';
import axios from 'axios';
import express from 'express';
​
const app = express();
​
const getApi = async (data) => {
  const response = await axios.post('http://115.40.230.109:8080', data);
​
  return response.data;
};
​
app.use(express.static(__dirname));
app.use(cors({ origin: true, credentials: true }));
​
app.post('/', (req, res) => {
  console.log(req.body);
  const result = getApi(req.body);
​
  res.status(200).send(result);
});