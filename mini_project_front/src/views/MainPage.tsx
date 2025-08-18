import { userInfoRequest } from "@/apis/user/User";
import type { UserInfoResponseDto } from "@/dtos/user/UserInfo.response.dto";
import { useEffect, useState } from "react";

function MainPage() {
  const [data, setData] = useState<UserInfoResponseDto>();
  const [message, setMessage] = useState("");

  const fetchUserInfo = async () => {
    try {
      const response = await userInfoRequest();
      const { code, message, data } = response;

      if (code === "SU") {
        setData(data);
      } else {
        setMessage(message);
      }
    } catch (error) {
      setMessage("네트워크 오류");
    }
  };

  useEffect(() => {
    fetchUserInfo();
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <h1>Main Page</h1>
      {data ? (
        <div>
          <p>Welcome</p>
          <p>{data.id}</p>
          <p>{data.name}</p>
          <p>{data.email}</p>
          <p>{data.role}</p>
        </div>
      ) : (
        <>
          <p>You are not logged in.</p>
          {message && <p>{message}</p>}
        </>
      )}
    </div>
  );
}

export default MainPage;
