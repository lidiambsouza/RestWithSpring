package br.com.erudio.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;


public class UploadFileResponseVO implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private String fileName;
	private String fileDownloadUri;	
	private String fileType;
	private long size;	
	
	public UploadFileResponseVO() {
	}

	public UploadFileResponseVO(String fileName, String fileDownloadUri, String fileType, long size) {
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return this.fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return this.size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof UploadFileResponseVO)) {
			return false;
		}
		UploadFileResponseVO uploadFileResponseVO = (UploadFileResponseVO) o;
		return Objects.equals(fileName, uploadFileResponseVO.fileName) && Objects.equals(fileDownloadUri, uploadFileResponseVO.fileDownloadUri) && Objects.equals(fileType, uploadFileResponseVO.fileType) && size == uploadFileResponseVO.size;
	}

	@Override
	public int hashCode() {		
		return Objects.hash(fileName, fileDownloadUri, fileType, size);
	}

	
	



		
}