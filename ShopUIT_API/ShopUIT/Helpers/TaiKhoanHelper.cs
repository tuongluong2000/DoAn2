using ShopUIT.Entities;
using ShopUIT.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ShopUIT.Helpers
{
    public class TaiKhoanHelper
    {
        public static List<TaiKhoanModel> ConvertTaiKhoans(List<TaiKhoan> taikhoans)
        {
            var TaiKhoanModels = taikhoans.ConvertAll(taikhoan => new TaiKhoanModel
            {
                Id = taikhoan.Id,
                Username = taikhoan.Username,
                Pass = taikhoan.Pass,
                Quyen = taikhoan.Quyen,
            });

            return TaiKhoanModels;
        }
    }
}
