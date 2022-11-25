package com.gdu.app14.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app14.domain.AttachDTO;
import com.gdu.app14.domain.UploadDTO;

@Mapper
public interface UploadMapper {
<<<<<<< HEAD
<<<<<<< HEAD
	
	public List<UploadDTO> selectUploadList();
	public int insertUpload(UploadDTO upload);
	public int insertAttach(AttachDTO attach);
	

}
=======
=======
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
	public List<UploadDTO> selectUploadList();
	public int insertUpload(UploadDTO upload);
	public int insertAttach(AttachDTO attach);
	public UploadDTO selectUploadByNo(int uploadNo);
	public List<AttachDTO> selectAttachList(int uploadNo);
	public int updateDownloadCnt(int attachNo);
	public AttachDTO selectAttachByNo(int attachNo);
	public int updateUpload(UploadDTO upload);
	public int deleteAttach(int attachNo);
	public int deleteUpload(int uploadNo);
	public List<AttachDTO> selectAttachListInYesterday();
<<<<<<< HEAD
}
>>>>>>> b5c256ee0d2db4290b9c7253b62aa7d62dbb3fab
=======
}
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
