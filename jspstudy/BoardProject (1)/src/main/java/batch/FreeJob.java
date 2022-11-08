package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import domain.Free;
import repository.FreeDAO;

public class FreeJob implements Job {
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Free mostHit = FreeDAO.getInstance().selectMostView();
		File file = new File("C:\\exam\\BoardProject\\top.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write("게시글번호 " + mostHit.getFreeNo() + "\n");
			bw.write("작성자 " + mostHit.getWriter() + "\n");
			bw.write("제목 " + mostHit.getTitle() + "\n");
			bw.write("작성IP " + mostHit.getIp() + "\n");
			bw.write("조회수 " + mostHit.getHit() + "\n");
			bw.write("내용\n" + mostHit.getContent() + "\n");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
