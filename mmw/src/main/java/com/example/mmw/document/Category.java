package com.example.mmw.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "category")
public class Category {

	@Id
	private String name;
	private List<Product> products;

//	,
//	{name:"Water_Pump_Motor"},
//	{name:"Submersible_Pumps"},
//	{name:"Bore_Well_Compressor_Pumps"},
//	{name:"Flour_Mill"},
//	{name:"Vacuum_Cleaner"},
//	{name:"Ceiling_Fan"},
//	{name:"Floor_Fan"},
//	{name:"Tower_Fan"},
//	{name:"	Exhaust_Fan"},
//	{name:"Industrtial_Fan"},
//	{name:"Table_Fan"},
//	{name:"Pedestal_Fan"},
//	{name:"	Window_Fan"},
//	{name:"Iron"},
//	{name:"Mixer_Grinder"},
//	{name:"blender"},
//	{name:"Tube_light"}

}
