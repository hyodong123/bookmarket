package bookmarket.model;

import java.util.Scanner;

import bookmarket.user.User;

public class admin {
    private String username;
    private String password;
    // 기타 선택적인 어드민 정보 필드들...

    public admin(String username, String password) {
        this.username = username;
        this.password = password;
        // 선택적인 정보들을 초기화합니다.
    }

    // 게터와 세터 메서드들...

    public static admin createAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("어드민 이름을 입력하세요: ");
        String username = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();
        // 기타 선택적인 정보들을 입력 받을 수 있습니다.

        return new admin(username, password);
    }

    public void displayUserInformation(User user) {
        System.out.println("사용자 이름: " + user.getUsername());
        System.out.println("이메일: " + user.getEmail());
        // 기타 사용자 정보들을 출력합니다.
    }

    public void addProduct(BookStorage bookStorage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("추가할 상품의 ID를 입력하세요: ");
        int bookId = scanner.nextInt();
        System.out.print("상품의 제목을 입력하세요: ");
        scanner.nextLine(); // 버퍼 비우기
        String title = scanner.nextLine();
        System.out.print("상품의 저자를 입력하세요: ");
        String author = scanner.nextLine();
        System.out.print("상품의 출판사를 입력하세요: ");
        String publisher = scanner.nextLine();
        System.out.print("상품의 가격을 입력하세요: ");
        int price = scanner.nextInt();

        Book newBook = new Book(bookId, title, author, publisher, price);
        bookStorage.addBook(newBook);

        System.out.println("상품이 추가되었습니다.");
    }

    public void removeProduct(BookStorage bookStorage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제할 상품의 ID를 입력하세요: ");
        int bookId = scanner.nextInt();

        if (bookStorage.isValidBook(bookId)) {
            bookStorage.removeBook(bookId);
            System.out.println("상품이 삭제되었습니다.");
        } else {
            System.out.println("해당 ID의 상품이 존재하지 않습니다.");
        }
    }

    // 기타 관리자 기능들을 추가할 수 있습니다.

    @Override
    public String toString() {
        return "Admin: " + username;
    }
}
