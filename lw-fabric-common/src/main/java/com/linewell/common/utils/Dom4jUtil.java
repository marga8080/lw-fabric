package com.linewell.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.linewell.common.Constants;

/**
 * Dom4j工具类
 * 
 * @author lzhicong@linewell.com
 * @since 2018-05-15
 */
public class Dom4jUtil {
	/**
	 * 构造函数私有化
	 * 
	 */
	private Dom4jUtil() {

	}

	private static Dom4jUtil instance = null;

	/**
	 * 提供Dom4jUtil的全局访问点
	 * 
	 * @return Dom4jUtil实例对象 Dom4jUtil
	 */
	public static Dom4jUtil getInstance() {
		if (instance == null) {
			synchronized (Dom4jUtil.class) {
				if (instance == null) {
					instance = new Dom4jUtil();
				}
			}
		}
		return instance;
	}

	/**
	 * 根据指定的编码进行格式化,如“UTF-8”
	 * 
	 * @return encode 编码 String
	 */
	public OutputFormat getFormat(String encode) {
		OutputFormat format = OutputFormat.createPrettyPrint();
		/** 指定XML编码 */
		format.setEncoding(encode);
		format.setIndent(" ");
		return format;

	}

	/**
	 * 从File中读取Document对象
	 * 
	 * @param file
	 *            文件对象 File
	 * 
	 * @return dom4j文档对象 Document
	 */
	public Document getXmlDocByFile(File file) {

		Document doc = null;
		SAXReader saxReader = new SAXReader();
		try {
			doc = saxReader.read(file);
		} catch (DocumentException e) {

			return null;
		}
		return doc;
	}

	/**
	 * 从request中读取Document对象
	 * 
	 * @param request
	 * @return
	 */
	public Document getXmlDocByInputStream(HttpServletRequest request) {
		Document doc = null;
		SAXReader saxReader = new SAXReader();
		InputStream in = null;
		try {

			try {
				in = request.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (in == null)
				return null;
			doc = saxReader.read(in);
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return doc;
	}

	/**
	 * 根据文件路径中读取Document对象
	 * 
	 * @param filename
	 *            文件路径 String
	 * 
	 * @return dom4j文档对象 Document
	 */
	public Document getXmlDocByFileName(String filename) {
		if (null == filename) {
			return null;
		}
		File file = new File(filename);
		if (!file.exists()) {
			return null;
		}
		Document doc = null;

		try {
			FileInputStream in = new FileInputStream(filename);
			Reader reader = new InputStreamReader(in, Constants.DEFAULT_CHARSET);
			SAXReader saxReader = new SAXReader();
			saxReader.setEncoding(Constants.DEFAULT_CHARSET);
			doc = saxReader.read(reader);

			// saxReader.setEncoding(Constants.DEFAULT_CHARSET);
			// doc = saxReader.read(new BufferedInputStream(new FileInputStream(filename)));
			// doc = saxReader.read(file);
		} catch (DocumentException e) {

			return null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}

	/**
	 * 根据URL地址读取Document对象
	 * 
	 * @param filename
	 *            文件路径 String
	 * 
	 * @return dom4j文档对象 Document
	 */
	public Document getXmlDocByURL(URL url) {

		Document doc = null;
		SAXReader saxReader = new SAXReader();
		try {
			doc = saxReader.read(url);
		} catch (DocumentException e) {

			return null;
		}
		return doc;
	}

	/**
	 * 根据内容读取Document对象
	 * 
	 * @param content
	 *            xml内容 String
	 * 
	 * @return dom4j文档对象 Document
	 */
	public Document getXmlDocByString(String content) {
		try {
			return DocumentHelper.parseText(content);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 输入（保存）XML到文件
	 * 
	 * @param doc
	 *            dom4j文档对象 Document
	 * 
	 * @param filename
	 *            文件路径 String
	 * 
	 * @param encode
	 *            编码 String
	 *
	 * 
	 */
	public void outPutXmlToFile(Document doc, String filename, String encode) {
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileWriter(new File(filename)), getFormat(encode));
			writer.write(doc);
			writer.close();
		} catch (IOException e1) {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		}

	}

	/**
	 * 进行打印输出xml
	 * 
	 * @param doc
	 *            dom4j的文档对象 Document
	 * 
	 * @param encode
	 *            编码 String
	 * 
	 */
	public void outPutSystemOut(Document doc, String encode) {
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(System.out, getFormat(encode));
			writer.write(doc);
			writer.close();
		} catch (IOException e1) {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		}

	}

	/**
	 * 在Document对象增加一result元素
	 * 
	 * @param result
	 *            元素内容 String
	 * 
	 * @return dom4j的Document对象 Document
	 */
	public Document getResultDoc(String result) {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("result");
		root.addText(result);
		return doc;
	}

	/**
	 * 获取dom4j的Document对象的内容
	 * 
	 * @return xml字符串 String
	 * 
	 */
	public String getString(Document document) {
		return document.asXML();

	}

	/**
	 * 返回该文档的根元素
	 * 
	 * @param doc
	 *            dom4j的文档对象 Document
	 * 
	 * @return 根节点 Element
	 */
	public Element getRootElement(Document doc) {
		return doc.getRootElement();
	}

	/**
	 * 校验获取指定路径的dom4j文档对象
	 * 
	 * @param xmlfile
	 *            xml文件地址
	 * 
	 * @return dom4j的文档对象 Document
	 */
	public Document valideDoc(String xmlfile) throws DocumentException, IOException {
		EntityResolver resolver = new EntityResolver() {
			public InputSource resolveEntity(String publicId, String systemId) {
				InputStream in = null;
				try {
					if (publicId.equals("//class from weiking")) {
						in = new FileInputStream("class.dtd");
						return new InputSource(in);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (null != in) {
						try {
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

				return null;
			}
		};
		SAXReader reader = new SAXReader(true);
		reader.setEntityResolver(resolver);
		Document doc = reader.read(new FileInputStream(xmlfile));
		return doc;
	}

	/**
	 * 根据官方的schema校验获取指定路径的dom4j文档对象
	 * 
	 * @param xmlfile
	 *            xml文件地址
	 * 
	 * @return dom4j的文档对象 Document
	 * 
	 */

	public Document validateDocByXsd(String xmlfile) throws SAXException, DocumentException, IOException {
		SAXReader reader = new SAXReader(true);
		reader.setFeature("http://apache.org/xml/features/validation/schema", true);
		Document doc = reader.read(new FileInputStream(xmlfile));
		return doc;
	}

	/**
	 * 根据指定的验证地址校验获取指定路径的dom4j文档对象
	 * 
	 * @param xmlfile
	 *            xmlfile xml文件地址
	 * 
	 * @param schemaUrl
	 *            schema地址 String
	 * 
	 * @return Document dom4j的文档对象 Document
	 * 
	 * 
	 */
	public Document validateDocByXsd(String xmlfile, String schemaUrl) throws SAXException, FileNotFoundException, DocumentException {
		SAXReader reader = new SAXReader(true);
		reader.setFeature("http://xml.org/sax/features/validation", true);
		reader.setFeature("http://apache.org/xml/features/validation/schema", true);
		reader.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);
		reader.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", schemaUrl);
		Document doc = reader.read(new FileInputStream(xmlfile));
		return doc;
	}

	/**
	 * 根据xsd文件对xml文件进行验证
	 * 
	 * @param xmlFile
	 *            xml文件
	 * @param xsdFile
	 *            xsd文件
	 * @return 验证结果
	 * @throws XmlException
	 */
	public boolean validateXmlByXsd(File xmlFile, File xsdFile) throws SAXException, IOException {
		boolean result = false;
		// 建立schema工厂
		SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

		// 利用schema工厂，接收验证文档文件对象生成Schema对象
		Schema schema = schemaFactory.newSchema(xsdFile);
		// 通过Schema产生针对于此Schema的验证器，利用schenaFile进行验证

		Validator validator = schema.newValidator();

		// 得到验证的数据源
		Source source = new StreamSource(xmlFile);

		validator.validate(source);

		result = true;

		return result;
	}

	/**
	 * 文件如果以File.separator结尾则去掉File.separator
	 * 
	 * @param path
	 *            对路径以"/"或“\\”进行去除 String
	 * 
	 * @return 回去截取或的结果 String
	 * 
	 * @throws 如果路径不是以"/"或“\\”结尾则抛出异常
	 */
	public static String pathFilter(String path) throws Exception {
		// 如果包含File.separator

		if (path.indexOf(File.separator) != -1)

		{// 如果path以File.separator结尾，则去掉File.separator
			if (path.endsWith(File.separator)) {
				path = path.substring(0, path.length() - 1);
			}
			return path;

		} else {
			throw new Exception("目录请使用" + File.separator + "分隔");
		}

	}

	/**
	 * 在xpathExpression下根据attribute=value得到元素内容列表
	 * 
	 * @param dom4j的document对象
	 *            Document
	 * 
	 * @param xpathExpression
	 *            xpath路径 /doc String
	 * 
	 * @param attribute
	 *            节点属性名称 String
	 * 
	 * @param value
	 *            节点属性值 String
	 * 
	 * @return 元素值列表 List<String>
	 */
	public static List<String> getContentByAttribute(Document document, String xpathExpression, String attribute, String value) {

		List<String> list = new ArrayList<String>();

		if (xpathExpression.endsWith("/")) {
			xpathExpression = xpathExpression.substring(0, xpathExpression.length() - 1);
		}
		List<?> attList = document.selectNodes(xpathExpression + "[@" + attribute + "='" + value + "']");
		Iterator<?> iter = attList.iterator();
		while (iter.hasNext()) {
			Element node = (Element) iter.next();
			list.add(node.getText());
		}

		return list;
	}

	/**
	 * 根据 节点的路径、属性名称和属性值，返回所有符合条件的节点
	 * 
	 * @param document
	 *            dom4j的document对象 Document
	 * 
	 * @param xpathExpression
	 *            xpath路径 /doc String
	 * 
	 * @param attribute
	 *            节点属性名称 String
	 * 
	 * @param value
	 *            节点属性值 String
	 * 
	 * @return list 元素列表 List
	 */
	public static List<?> getElementListByAttribute(Document document, String xpathExpression, String attribute, String value) {
		if (xpathExpression.endsWith("/")) {
			xpathExpression = xpathExpression.substring(0, xpathExpression.length() - 1);
		}
		List<?> list = document.selectNodes(xpathExpression + "[@" + attribute + "='" + value + "']");
		return list;
	}
}
