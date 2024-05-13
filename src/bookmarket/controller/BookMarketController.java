package bookmarket.controller;

import bookmarket.model.BookStorage;
import bookmarket.model.Cart;
import bookmarket.model.admin;
import bookmarket.user.User;
import bookmarket.view.ConsoleView;

public class BookMarketController {
    ConsoleView view;
    BookStorage mBookStorage;
    Cart mCart;
    String[] menuList = {
        "0. 종료",
        "1. 도서 정보 보기",
        "2. 장바구니 보기",
        "3. 장바구니에 도서 담기",
        "4. 장바구니 비우기",
        "5. 로그인"
    };

    public BookMarketController(BookStorage bookStorage, Cart cart, ConsoleView view) {
        this.view = view;
        this.mBookStorage = bookStorage;
        this.mCart = cart;
    }

    public void start() {
        view.displayWelcome();

        int menu;

        do {
            menu = view.selectMenu(menuList);

            switch (menu) {
                case 1:
                    viewBookInfo();
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    addBook2Cart();
                    break;
                case 4:
                    resetCart();
                    break;
                case 5:
                    login();
                    break;
            }
        } while (menu != 0);
        view.showMessage(">> Hyodong Book Market을 종료합니다.");
    }

    private void login() {
        // 간단하게 하기 위해 하드코딩된 사용자 정보를 사용합니다.
        String username = "user";
        String password = "1234";
        String adminUsername = "admin";
        String adminPassword = "admin123";

        String inputUsername = view.askForInput("사용자 이름을 입력하세요: ");
        String inputPassword = view.askForInput("비밀번호를 입력하세요: ");

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            // 사용자로 로그인한 경우
            User user = new User(username, password);
            userMenu(user);
        } else if (inputUsername.equals(adminUsername) && inputPassword.equals(adminPassword)) {
            // 어드민으로 로그인한 경우
            Admin admin = new Admin(adminUsername, adminPassword);
            adminMenu(null);
        } else {
            view.showMessage("잘못된 사용자 이름 또는 비밀번호입니다.");
        }
    }

    private void userMenu(User user) {
        // 사용자가 할 수 있는 기능을 추가하세요.
        view.showMessage("사용자로 로그인하셨습니다.");
    }

    private void adminMenu(admin admin) {
        // 어드민이 할 수 있는 기능을 추가하세요.
        view.showMessage("어드민으로 로그인하셨습니다.");
    }

    private void resetCart() {
        view.displayCart(mCart);

        if (!mCart.isEmpty()) {
            view.askConfirm(">> 장바구니를 비우려면 yes를 입력하세요 : ", "yes");
            mCart.resetCart();
            view.showMessage(">> 장바구니를 비웠습니다.");
        }
    }

    private void addBook2Cart() {
        view.displayBookInfo(mBookStorage);
        int bookId = view.selectBookId(mBookStorage);
        mCart.addItem(mBookStorage.getBookId(bookId));
        view.showMessage(">>장바구니에 도서를 추가하였습니다.");
    }

    private void viewCart() {
        view.displayCart(mCart);
    }

    private void viewBookInfo() {
        view.displayBookInfo(mBookStorage);
    }
}
