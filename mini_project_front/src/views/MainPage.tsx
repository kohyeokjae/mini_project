import { bookListRequest } from "@/apis/book/Book";
import type { BookListResponseDto } from "@/dtos/book/response/BookList.response.dto";
import { useEffect, useState } from "react";
import "@/styles/style.css";

function MainPage() {
  const [data, setData] = useState<BookListResponseDto[]>([]);
  const [message, setMessage] = useState("");

  const fetchUserInfo = async () => {
    try {
      const response = await bookListRequest();
      const { code, message, data } = response;

      if (code === "SU" && data) {
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
      <h1>책 목록</h1>
      {message && <p>{message}</p>}
      <table>
        <thead>
          <tr>
            <th>표지</th>
            <th>Isbn</th>
            <th>제목</th>
            <th>저자</th>
            <th>카테고리</th>
            <th>출판사</th>
            <th>가격</th>
            <th>출판일</th>
          </tr>
        </thead>
        <tbody>
          {data.map((book) => (
            <tr key={book.isbn}>
              <td>{book.coverUrl}</td>
              <td>{book.isbn}</td>
              <td>{book.bookTitle}</td>
              <td>{book.authorName}</td>
              <td>{book.categoryName}</td>
              <td>{book.publisherName}</td>
              <td>{book.bookPrice.toLocaleString()}원</td>
              <td>{book.publishedDate}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default MainPage;
