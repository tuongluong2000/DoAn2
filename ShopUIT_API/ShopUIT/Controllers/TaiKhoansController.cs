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
    public class TaiKhoansController : ControllerBase
    {
        private readonly ITaiKhoanService TaiKhoanService;
        public TaiKhoansController(ITaiKhoanService TaiKhoanService)
        {
            this.TaiKhoanService = TaiKhoanService;
        }

        [HttpGet]
        [Route("")]
        public async Task<IActionResult> Get()
        {
            var TaiKhoans = await TaiKhoanService.GetAllTaiKhoan();

            var Models = TaiKhoanHelper.ConvertTaiKhoans(TaiKhoans);

            return Ok(Models);
        }

        [HttpGet]
        [Route("{username}/taikhoan")]
        public async Task<IActionResult> GetTaiKhoan(string username, string pass)
        {
            var TaiKhoans = await TaiKhoanService.GetTaiKhoanByUsernamePass(username, pass);

            var TaiKhoanModels = TaiKhoanHelper.ConvertTaiKhoans(TaiKhoans);

            return Ok(TaiKhoanModels);
        }
    }
}
