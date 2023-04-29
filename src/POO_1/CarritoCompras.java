package POO_1;

import java.time.LocalDate;




public class CarritoCompras {


		public static void main(String[] args) {
			
			Producto prod1 = new Producto(100, "Jugo", 530.50, "Jugo de Naranja Caja x 1l",100);
			Producto prod2 = new Producto(101, "Queso Crema", 460.80, "Filandia x 300gr",100);
			Producto prod3 = new Producto(102, "Fideos", 230.50,"Paquete x 500gr",200);

			
		
			Cliente per1 = new Cliente(26638449,"Gismary Laya","Dock Sud 2515","11 66574878","gismarylo25012gmail.com");
				
		
			Carrito carro = new Carrito(40, per1);
			
			ItemCarrito cargaItem[] = new ItemCarrito[3]; 
			cargaItem[0] = new ItemCarrito(carro, prod1, 3);
			cargaItem[1] = new ItemCarrito(carro, prod2, 1);
			cargaItem[2] = new ItemCarrito(carro, prod3, 5);
			cargaItem[0].dameTitulo();
			
			double monto =mostrarCompras(cargaItem,carro,per1);
			
			
			System.out.println ("==================================================");
			
			carro.mostrarMontoCarrito(monto);
			
			System.out.println ("==================================================");
			
		
			DescuentoPorcentaje desc1 = new DescuentoPorcentaje ("Descuento por pago en efectivo","Efectivo",0.20);
			// TP7 - N�1
			carro.setDescPorc(desc1);
			
			DescuentoFijo desc2 = new DescuentoFijo ("Descuento por cupon","Cupon",200.00);
			// TP7 - N�1
			carro.setCupDesc(desc2);
			
			
		
			if (desc1.dameTipo()=="Efectivo") {
				desc1.setMontoDescuento(0.20);
				System.out.println(desc1.getDescripcion()+" " +desc1.dameValorDescuento()*100 + "%");
				System.out.printf("Monto Descontado: %.2f%n" , desc1.dameMontoDescuento(carro.dameMontoCarrito()));
				System.out.printf ("TOTAL A PAGAR (Efectivo): %.2f%n", desc1.dameMontoFinal(carro.dameMontoCarrito()));
				System.out.println ("==================================================");
			
				
			} 	if (desc2.dameTipo()=="Cupon") {
				desc2.setMontoDescuento(200);
				System.out.println(desc2.getDescripcion()+" " +desc2.dameValorDescuento());
				System.out.printf("TOTAL A PAGAR (cupon): %.2f%n" , desc2.valorFinal(carro.dameMontoCarrito()));
					
					
				System.out.println ("==================================================");
				
							
			
				} 
			
			/* TP7. N� 1 - Al programa del carrito de la Clase 5, agregue un par�metro que indique si hay un
			descuento fijo o % y ponga el valor del mismo. */
			
			
			carro.consultarDescuento();
			
			descuentos (carro.dameMontoCarrito());
							
		}
		
		
		
			// TP7. N� 2. Agregue un nuevo descuento %, pero que tenga un tope Fijo 
		
		public static void descuentos(double monto) {

			LocalDate fecha = LocalDate.now();

			int dia = fecha.getDayOfMonth();

			if (dia%2==0) {

			Descuento descF = new DescuentoFijo("Descuento por cupon","Cupon",200.00);

			descF.setMontoDescuento(35.5);

			System.out.println("El monto total con descuento es:"+descF.valorFinal(monto));

			}

			else {

			Descuento descP = new DescuentoPorcentaje("Descuento por pago en efectivo","Efectivo",0.20);

			descP.setMontoDescuento(0.05);

			System.out.printf("El monto total con descuento por fecha es: %.2f" , descP.valorFinal(monto));

			}

			}
		
		
		
		public static double mostrarCompras(ItemCarrito cargarItem[], Carrito carro, Cliente per1) {
			double suma = 0;
			
			for (ItemCarrito item : cargarItem) {
				item.mostrarItem();	
				suma = suma + item.dameMontoItem();
			}
			
			return suma;
			

			}
		

	}
