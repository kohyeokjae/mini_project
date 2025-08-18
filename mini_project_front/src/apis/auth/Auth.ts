import type ResponseDto from "@/dtos/Response.dto";
import {
  axiosInstance,
  responseErrorHandler,
  responseSuccessHandler,
} from "../axiosConfig";
import { LOGOUT_URL } from "../constants/constants";
import type { AxiosError } from "axios";

export const logoutResquest = async (): Promise<ResponseDto<void>> => {
  try {
    const response = await axiosInstance.post(LOGOUT_URL, null, {
      withCredentials: true,
    });
    return responseSuccessHandler(response);
  } catch (error) {
    return responseErrorHandler(error as AxiosError<ResponseDto>);
  }
};
