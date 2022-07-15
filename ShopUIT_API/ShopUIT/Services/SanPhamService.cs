using Microsoft.EntityFrameworkCore;
using ShopUIT.Entities;
using ShopUIT.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ShopUIT.Services
{
    public class SanPhamService : ISanPhamService
    {
        private readonly ShopUITDbContext ShopUITDbContext;
        public SanPhamService(ShopUITDbContext ShopUITDbContext)
        {
            this.ShopUITDbContext = ShopUITDbContext;
        }
        public async Task<List<SanPham>> GetAllSanPham()
        {
            var sanphams = ShopUITDbContext.sanPhams;
            return await sanphams.ToListAsync();
        }

     
        public async Task<List<SanPham>> GetSanPhamById(int id)
        {
            var sanphams = ShopUITDbContext.sanPhams.Where(t => t.Id == id );
            return await sanphams.ToListAsync();
        }

        public async Task<List<SanPham>> GetSanPhamByLSP(int lsp)
        {
            var sanphams = ShopUITDbContext.sanPhams.Where(t => t.Idlsp == lsp);
            return await sanphams.ToListAsync();
        }
    }
}
