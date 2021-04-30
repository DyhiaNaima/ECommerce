package org.sid.ecommerce.controllers;

import org.springframework.http.MediaType;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.sid.ecommerce.entities.Categorie;
import org.sid.ecommerce.metier.IAdminCategoriesMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/adminCat")
public class AdminCategoriesController implements HandlerExceptionResolver{
	@Autowired
	private IAdminCategoriesMetier metier;
	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}
	// ajouter une categorie 
	@RequestMapping(value="saveCat" , method = RequestMethod.POST)
	public String saveCat(@Valid Categorie c ,BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile multipartFile) 
			throws IOException
	{
		
		/*  Si Il ya des Erruers */
		if(bindingResult.hasErrors())
		{
			model.addAttribute("categories",metier.listCategories());
			return "categories";
		}
		/*  Si Il ya un Upload*/
		if(! multipartFile.isEmpty() )
		{
			// TESTER QU IL S AGIT D UNE IMAGE ( MEME ON PEUT LA RETOUCHER )
			BufferedImage bi = ImageIO.read(multipartFile.getInputStream());  // S il est autre qu une image, il va lever une exception
			c.setPhoto(multipartFile.getBytes());
			c.setNomPhoto(multipartFile.getOriginalFilename());
		}
		
		if(c.getIdcategorie() != null)	
			metier.modifierCategorie(c);
		else
		{
			metier.ajouterCategorie(c);
		}
		
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories",metier.listCategories());
		return "categories";
	}

	@RequestMapping(value="CatPhoto", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(@RequestParam Long idCat) throws IOException
	{
		Categorie c = metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categories");
		return mv;
	}
	
	
}
