using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using ShopUIT.Helpers;
using ShopUIT.Interfaces;

namespace ShopUIT.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class SanPhamsController : ControllerBase
    {
        private readonly ISanPhamService SanPhamService;
        public SanPhamsController(ISanPhamService SanPhamService)
        {
            this.SanPhamService = SanPhamService;
        }

        [HttpGet]
        [Route("")]
        public async Task<IActionResult> GetAllSanPham()
        {
            var SanPhams = await SanPhamService.GetAllSanPham();

            //var Models = TaiKhoanHelper.ConvertSanPhams(SanPhams);

            return Ok(SanPhams);
        }

        [HttpGet]
        [Route("SanPham/{id}")]
        public async Task<IActionResult> GetSanPhamById(int id)
        {
            var SanPhams = await SanPhamService.GetSanPhamById(id);

            //var TaiKhoanModels = TaiKhoanHelper.ConvertSanPhams(SanPhams);

            return Ok(SanPhams);
        }

        [HttpGet]
        [Route("SanPham/LoaiSanPham/{lsp}")]
        public async Task<IActionResult> GetSanPhamByLSP(int lsp)
        {
            var SanPhams = await SanPhamService.GetSanPhamByLSP(lsp);

            //var TaiKhoanModels = TaiKhoanHelper.ConvertSanPhams(SanPhams);

            return Ok(SanPhams);
        }
    }
}
