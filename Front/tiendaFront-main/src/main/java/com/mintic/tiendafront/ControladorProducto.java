package com.mintic.tiendafront;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mintic.tiendafront.client.IClientTienda;
import com.mintic.tiendafront.client.IProducto;
import com.mintic.tiendafront.dto.ProductoDto;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


@Controller
public class ControladorProducto {
	
	@Autowired
	IProducto iProducto;
	
	
	@GetMapping("/producto")
	public String a() {
		return "producto";
	}
	
	
	@GetMapping("/producto/{codigoProducto}")
	public String buscarProducto(Model model, @PathVariable Long codigoProducto) {
		
		ProductoDto producto = iProducto.buscarProductoPorCodigo(codigoProducto);
		model.addAttribute("producto", producto);
		
		
		return "producto";
	}
	
	@PostMapping("/producto")
	public String productos(@RequestParam("file") MultipartFile file, Model model) {

		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("status", false);
		} else {

			try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

				CsvToBean<ProductoDto> csvToBean = new CsvToBeanBuilder(reader).withType(ProductoDto.class)
						.withIgnoreLeadingWhiteSpace(true).build();

				List<ProductoDto> producto = csvToBean.parse();

				for (int i = 0; i < producto.size(); i++) {

					System.out.println(producto.get(i).getNombreProducto());
					iProducto.crearProducto(producto.get(i));
				}
				

				model.addAttribute("producto", producto);
				model.addAttribute("status", true);
				

			} catch (Exception ex) {
				model.addAttribute("message", "An error occurred while processing the CSV file.");
				model.addAttribute("status", false);
			}
		}
		

		return ("producto");
	}
	
	
	
	
	
}
