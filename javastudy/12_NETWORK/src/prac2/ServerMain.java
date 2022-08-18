package prac2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {
	
	// Server : 스레드
	// Client : 스레드
	// Server 하나가 Client 하나를 담당
	
	// 생성된 Server 목록
	public static List<Server> servers = new ArrayList<>();
	
	public static void main(String[] args) {

		ServerSocket server = null;
		Socket client = null;
		
		try {
			
			server = new ServerSocket();
			server.bind(new InetSocketAddress("localhost", 9090));
			
			System.out.println("▤ 채팅 서버 오픈 ▤");
			
			while(true) {
				
				// 서버 중지 조건은 없는 상태임
				
				client = server.accept();
				System.out.println("클라이언트 접속(" + client.getInetAddress() + ")");
				
				Server s = new Server(client);			
				s.start();
				
				servers.add(s);
				
				System.out.println("현재 접속 중인 클라이언트 " + servers.size() + "명");
				
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(server.isClosed() == false) {
					server.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}