import type { BookListResponseDto } from "@/dtos/book/response/BookList.response.dto";
import type ResponseDto from "@/dtos/Response.dto";
import {
  axiosInstance,
  responseErrorHandler,
  responseSuccessHandler,
} from "../axiosConfig";
import { BOOK_LIST_URL } from "../constants/constants";
import type { AxiosError } from "axios";

export const bookListRequest = async (): Promise<
  ResponseDto<BookListResponseDto[]>
> => {
  try {
    const response = await axiosInstance.get(BOOK_LIST_URL);
    return responseSuccessHandler(response);
  } catch (error) {
    return responseErrorHandler(error as AxiosError<ResponseDto>);
  }
};
