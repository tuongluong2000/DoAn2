using Microsoft.EntityFrameworkCore;
using ShopUIT.Entities;
using ShopUIT.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ShopUIT.Services
{
    public class TaiKhoanService : ITaiKhoanService
    {
        private readonly ShopUITDbContext ShopUITDbContext;
        public TaiKhoanService(ShopUITDbContext ShopUITDbContext)
        {
            this.ShopUITDbContext = ShopUITDbContext;
        }
        public async Task<List<TaiKhoan>> GetAllTaiKhoan()
        {
            var taikhoans = ShopUITDbContext.TaiKhoans;
            return await taikhoans.ToListAsync();
        }
        public async Task<List<TaiKhoan>> GetTaiKhoanByUsernamePass(string username, string pass)
        {
            var taikhoans = ShopUITDbContext.TaiKhoans.Where(t => t.Username == username && t.Pass == pass);
            return await taikhoans.ToListAsync();
        }    
    }
}
