
/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package gestionalmacen01.modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ModeloHashMap implements ModeloAbs
{
    private HashMap <Integer,Producto> mapa;

    // COMPLETAR
    
    public ModeloHashMap()
    {
       mapa=new HashMap  <Integer,Producto>();
    }

	@Override
	public boolean insertarProducto(Producto p) {
		// TODO Auto-generated method stub
		if (mapa.containsKey(p.codigo)) {
			return false;
		}
		mapa.put(p.codigo, p);
		return true;
	}

	@Override
	public boolean borrarProducto(int codigo) {
		// TODO Auto-generated method stub
		return (mapa.remove(codigo)!=null);
	}

	@Override
	public boolean modificarProducto(Producto nuevo) {
		// TODO Auto-generated method stub
		//return (mapa.containsValue(nuevo));
		if (mapa.containsKey(nuevo.codigo)) {
			mapa.put(nuevo.codigo, nuevo);
			return true;
		}
		return false;
	}

	@Override
	public Producto buscarProducto(int codigo) {
		// TODO Auto-generated method stub
		return mapa.get(codigo);
	}

	@Override
	public void imprimirProductosTodos() {
		// TODO Auto-generated method stub
		for (Producto p : mapa.values()) {
			System.out.println(p.toString());
		}
	}

	@Override
	public List<Producto> obtenerProductos() {
		// TODO Auto-generated method stub
		return new ArrayList<Producto>(mapa.values());
	}

	@Override
	public List<Producto> obtenerProductosStockMin() {
		// TODO Auto-generated method stub
		List<Producto> listaStockMin = new ArrayList<Producto>();
		for (Producto p : mapa.values()) {
			if(p.stock <= p.stock_min) {	
				listaStockMin.add(p);
			}
		}
		return listaStockMin;
	}

  
}
