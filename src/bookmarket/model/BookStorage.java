package bookmarket.model;

public class BookStorage {
	Book[] bookList;

	public BookStorage() {
		bookList = new Book[] { new Book(2401, "쉽게 배우는 자바 프로그래밍 2판", "우종정", "한빛아카데미", 20000),
				new Book(2402, "코딩 자율학습 HTML+CSS+자바스크립트", "김기수", "길벗", 30000),
				new Book(2403, "Do It! 자료구조와 함께 배우는 알고리즘 입문 - 자바편", "보요시바타", "이지스퍼블리싱", 25000) };
	}

	public int getNumBooks() {
		return bookList.length;
	}

	public String getBookInfo(int i) {
		return bookList[i].toString();
	}

	public boolean isValidBook(int bookId) {
		for (Book book : bookList) {
			if (book.getBookId() == bookId)
				return true;
		}
		return false;
	}

	public Book getBookId(int bookId) {
		for (Book book : bookList) {
			if (book.getBookId() == bookId)
				return book;
		}
		return null;
	}

	public void addBook(Book newBook) {
		// 배열의 길이를 증가시키고, 새로운 책을 추가합니다.
		Book[] newArray = new Book[bookList.length + 1];
		System.arraycopy(bookList, 0, newArray, 0, bookList.length);
		newArray[bookList.length] = newBook;
		bookList = newArray;
	}

	public void removeBook(int bookId) {
	    // 주어진 bookId와 일치하는 책을 찾아 삭제합니다.
	    for (int i = 0; i < bookList.length; i++) {
	        if (bookList[i].getBookId() == bookId) {
	            Book[] newArray = new Book[bookList.length - 1];
	            System.arraycopy(bookList, 0, newArray, 0, i);
	            System.arraycopy(bookList, i + 1, newArray, i, bookList.length - i - 1);
	            bookList = newArray;
	            break;
	        }
	    }
	}
}