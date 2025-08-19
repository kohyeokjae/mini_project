import { userInfoRequest } from "@/apis/user/User";
import type { UserInfoResponseDto } from "@/dtos/user/UserInfo.response.dto";
import { useEffect, useState } from "react";

function MyPage() {
  const [data, setData] = useState<UserInfoResponseDto>();

  const fetchUserInfo = async () => {
    const response = await userInfoRequest();
    const { code, message, data } = response;

    if (code === "SU" && data) {
      setData(data);
    }
  };

  useEffect(() => {
    fetchUserInfo();
  }, []);

  return (
    <div>
      <p>{data?.id}</p>
      <p>{data?.name}</p>
      <p>{data?.email}</p>
      <p>{data?.phoneNumber}</p>
      <p>{data?.role}</p>
    </div>
  );
}

export default MyPage;
