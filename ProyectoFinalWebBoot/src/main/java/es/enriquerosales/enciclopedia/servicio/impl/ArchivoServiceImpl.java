package es.enriquerosales.enciclopedia.servicio.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.enriquerosales.enciclopedia.servicio.ArchivoService;
import es.enriquerosales.enciclopedia.servicio.ServiceException;

/**
 * Implementación de {@link ArchivoService}.
 * 
 * @author Enrique Rosales
 *
 */
@Service
public class ArchivoServiceImpl implements ArchivoService {

	@Override
	public void guardar(MultipartFile file, String destino) throws ServiceException {
		BufferedInputStream entrada = null;
		BufferedOutputStream salida = null;

		try {
			// abrimos fichero para lectura
			entrada = new BufferedInputStream(file.getInputStream());
			// abrimos fichero para escritura
			salida = new BufferedOutputStream(new FileOutputStream(new File(destino)));

			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = entrada.read(bytes)) != -1) {
				salida.write(bytes, 0, read);
			}
		} catch (IOException e) {
			throw new ServiceException(e);
		} finally {
			try {
				if (entrada != null) {
					entrada.close();
				}
				if (salida != null) {
					salida.flush();
					salida.close();
				}
			} catch (IOException e) {
				throw new ServiceException(e);
			}
		}

	}

	@Override
	public void eliminar(String destino) throws ServiceException {
		try {
			File archivo = new File(destino);
			archivo.delete();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
