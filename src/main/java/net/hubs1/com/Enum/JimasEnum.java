package net.hubs1.com.Enum;

/**
 * @author weqinjia.liu
 * @Date 2016年7月25日
 */
public enum JimasEnum {
	Monday {
		@Override
		public JimasEnum nextDay() {
			return Tuesday;
		}
	},
	Tuesday {
		@Override
		public JimasEnum nextDay() {
			return Wednesday;
		}
	},
	Wednesday {
		@Override
		public JimasEnum nextDay() {
			return Thursday;
		}
	},
	Thursday {
		@Override
		public JimasEnum nextDay() {
			return Friday;
		}
	},
	Friday {
		@Override
		public JimasEnum nextDay() {
			return Saturday;
		}
	},
	Saturday {
		@Override
		public JimasEnum nextDay() {
			return Sunday;
		}
	},
	Sunday {
		@Override
		public JimasEnum nextDay() {
			return Monday;
		}
	};

	public abstract JimasEnum nextDay();
}
// Monday 星期一 Tuesday 星期二 Wednesday 星期三 Thursday 星期四 Friday 星期五 Saturday 星期六  Sunday 星期日