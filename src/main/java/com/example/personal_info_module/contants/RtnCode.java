package com.example.personal_info_module.contants;


	public enum RtnCode{
		
		SUCCESSFUL(true, "成功しました"),
		ACCOUNT_CREATE_SUCCESSFUL(true, "新規登録成功しました"),
		ACCOUNT_EDIT_SUCCESSFUL(true, "更新成功しました"),
		ACCOUNT_DELETE_SUCCESSFUL(true, "無効化成功しました"),
		CANNOT_EMPTY(false, "記入が必須の欄まだあります"),
		CANNOT_DELETE(false, "既に無効化している情報です"),
		NOT_FOUND(false, "資料が見つかりませんでした");
		
		
		private Boolean type;
		private String message;
		public Boolean getType() {
			return type;
		}
		public void setType(Boolean type) {
			this.type = type;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		private RtnCode(Boolean type, String message) {
			this.type = type;
			this.message = message;
		}
		
	}


