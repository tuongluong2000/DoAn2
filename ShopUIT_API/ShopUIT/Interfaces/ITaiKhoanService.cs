using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ShopUIT.Entities;

namespace ShopUIT.Interfaces
{
    public interface ITaiKhoanService
    {
        Task<List<TaiKhoan>> GetAllTaiKhoan();
        Task<List<TaiKhoan>> GetTaiKhoanByUsernamePass(string username, string pass);
    
    }
}
