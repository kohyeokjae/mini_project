import { useLoginStore } from '@/stores/Login.store';
import { useEffect } from 'react'
import { useCookies } from 'react-cookie';
import { useNavigate } from 'react-router-dom';

function LoginCallBack() {
const navigate = useNavigate();
  const { setLogin, setLogout } = useLoginStore();
  const [cookies] = useCookies(["accessToken"]);
  const token = cookies.accessToken;


  useEffect(() => {
    try {

      if (!token) {
        setLogin(); 
        navigate("/main"); 
      } else {
        setLogout();
        navigate("/login");
      }
    } catch (error) {
      console.error("Login callback error:", error);
      setLogout();
      navigate("/login");
    }
  }, []);

  return <div>로그인 처리 중...</div>;
}

export default LoginCallBack