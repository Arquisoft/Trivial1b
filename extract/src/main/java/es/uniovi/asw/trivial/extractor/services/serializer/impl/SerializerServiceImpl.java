package es.uniovi.asw.trivial.extractor.services.serializer.impl;

import es.uniovi.asw.trivial.extractor.services.serializer.Serializer;
import es.uniovi.asw.trivial.extractor.services.serializer.SerializerService;
/**
 * 
 * @author Adrián
 *
 */
public class SerializerServiceImpl implements SerializerService {
	/*
	 * (non-Javadoc)
	 * @see es.uniovi.asw.trivial.extractor.services.serializer.SerializerService#getSerializerJson()
	 */
	public Serializer getSerializerJson(){
		return new JSonSerializer();
	}
}
