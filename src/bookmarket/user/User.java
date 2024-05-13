package bookmarket.user;

import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String email;
    // 기타 선택적인 사용자 정보 필드들...

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        // 선택적인 정보들을 초기화합니다.
    }

    // 게터와 세터 메서드들...

    public User(String username2, String password2) {
		// TODO Auto-generated constructor stub
	}

	public static User createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("사용자 이름을 입력하세요: ");
        String username = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();
        System.out.print("이메일을 입력하세요: ");
        String email = scanner.nextLine();
        // 기타 선택적인 정보들을 입력 받을 수 있습니다.

        return new User(username, password, email);
    }

    @Override
    public String toString() {
        return "User: " + username + ", Email: " + email;
    }

	public String getUsername1() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail1() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
}
