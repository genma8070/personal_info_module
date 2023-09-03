package com.example.personal_info_module.contants;


	public enum Pattern{
		NAME(false, "^.{0,20}$", "名前は1~20桁以内で入力してください"),
		NAME_ROMA(false, "^[a-zA-Z]{1,30}$", "名前(ローマ字)は1~30桁以内及び英語のみで入力してください"),
		NAME_KATAKANA(false, "^[ァ-ヶー　]{1,20}$", "名前(カタカナ)は1~20桁以内及びカタカナのみで入力してください"),
		REGION(false, "^.{1,20}$", "国籍は1~20桁以内で入力してください"),
		AGE(false, "^(?:[2-9][0-9])$", "年齢は20~99以内で入力してください"),
		MY_NUMBER(false, "^[0-9]{12}$", "マイナンバーは12桁及び数字のみで入力してください"),
		PASSPORT_NUMBER(false, "^[A-Z0-9< ]{1,15}$", "パスポート番号は1~15桁及び英数のみで入力してください"),
		RESIDENT_CARD_NUMBER(false, "^[A-Z]{2}\\d{8}[A-Z]{2}$", "在留カード番号は12桁及び英数のみで入力してください"),
		CELLPHONE(false, "^(080|090|070|060|050)\\d{8}$", "携帯番号は11桁及び数字のみで入力してください"),
		TELEPHONE(false, "^0\\d{9}$", "電話番号は10桁及び数字のみで入力してください"),
		POST_CODE(false, "^[0-9]{7}$", "郵便番号は7桁及び数字のみで入力してください"),
		ADDRESS(false, "^.{1,45}$", "住所は1~45桁以内で入力してください"),
		EMPLOYMENT_INSURANCE_NUMBER(false, "^[0-9]{11}$", "雇用保険番号は11桁及び数字のみで入力してください"),
		PENSION_NUMBER(false, "^[0-9]{10}$", "年金番号は10桁及び数字のみで入力してください"),
		BANK_ACCOUNT_NUMBER(false, "^[0-9]{7}$", "口座番号は7桁及び数字のみで入力してください"),
		BANK_NAME(false, "^[ぁ-んァ-ヶー一-龠々〆ヵヶa-zA-Z0-9 ]{1,20}$", "銀行名称は20桁及び日本語のみで入力してください"),
		HEADQUARTERS(false, "^[ぁ-んァ-ヶー一-龠々〆ヵヶa-zA-Z0-9 ]{1,20}$", "本店名は20桁及び日本語のみで入力してください"),
		MAIL(false, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", "正しいメールアドレスのフォーマット及び10~30桁以内で入力してください");
		
		private String Pattern;
		private String message;
		private Boolean type;
		
		public String getPattern() {
			return Pattern;
		}
		public void setPattern(String pattern) {
			Pattern = pattern;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		private Pattern(String pattern, String message) {
			Pattern = pattern;
			this.message = message;
		}
		private Pattern(String message) {
			this.message = message;
		}
		public Boolean getType() {
			return type;
		}
		public void setType(Boolean type) {
			this.type = type;
		}
		private Pattern(Boolean type) {
			this.type = type;
		}
		private Pattern(Boolean type, String pattern, String message) {
			this.type = type;
			Pattern = pattern;
			this.message = message;
		}
		
	}


