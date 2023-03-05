package kodlama.io.rentACar.business.requests.car;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	@NotNull
	private int id;
	
	private String plate;
	private double dailyPrice;
	private int modelYear;
	private int state;  //1-Available 2-Rented 3-Maintenan
	
	@NotNull
	private int modelId;
}
