import type ResponseDto from "@/dtos/Response.dto";
import {
  axiosInstance,
  responseErrorHandler,
  responseSuccessHandler,
} from "../axiosConfig";
import { AxiosError } from "axios";
import type { UserInfoResponseDto } from "@/dtos/user/UserInfo.response.dto";
import { USER_INFO_URL } from "../constants/constants";

export const userInfoRequest = async (): Promise<
  ResponseDto<UserInfoResponseDto>
> => {
  try {
    const response = await axiosInstance.get(USER_INFO_URL);
    return responseSuccessHandler(response);
  } catch (error) {
    return responseErrorHandler(error as AxiosError<ResponseDto>);
  }
};
