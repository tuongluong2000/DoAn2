using ShopUIT.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ShopUIT.Interfaces
{
    public interface ISanPhamService
    {
        Task<List<SanPham>> GetAllSanPham();
        Task<List<SanPham>> GetSanPhamById(int id);
        Task<List<SanPham>> GetSanPhamByLSP(int lsp);
    }
}
